package com.rest.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rest.api.advice.exception.CUserNotFoundException;
import com.rest.api.entity.User;
import com.rest.api.model.response.*;
import com.rest.api.repo.UserJpaRepo;
import com.rest.api.service.ResponseService;

import io.swagger.annotations.*;

// Swagger UI 적용
// SwaggerUI http://localhost:8080/swagger-ui.html


@Api(tags = {"1. User"})
//@RequiredArgsConstructor ..//class상단에 선언하면 class내부에 final로 선언된 객체에 대해서 Constructor Injection을 수행합니다. 해당 어노테이션을 사용하지 않고 선언된 객체에 @Autowired를 사용해도 됩니다.
@RestController // 결과 데이터를 JSON으로 내보냅니다.
@RequestMapping(value = "/v1")
public class UserController  {
    @Autowired
    UserJpaRepo userJpaRepo;

    @Autowired
    ResponseService responseService;

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다.")
    @GetMapping(value = "/users")
    public ListResult<User> findAllUser() {
        // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
        return responseService.getListResult(userJpaRepo.findAll());
    }

    @ApiOperation(value = "회원 단건 조회", notes = "UserId로 회원을 조회한다.")
    @GetMapping(value = "/user/{msrl}")
    public SingleResult<User> findUserById(@ApiParam(value = "회원 ID", required = true) @PathVariable Long msrl,
                                           @ApiParam(value = "언어", defaultValue = "ko") @RequestParam String lang) {
        // 결과데이터가 단일건인경우 getBasicResult를 이용해서 결과를 출력한다.
        return responseService.getSingleResult(userJpaRepo.findById(msrl).orElseThrow(CUserNotFoundException::new));

    }

    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
    @PostMapping(value = "/user")
    public SingleResult<User> save(@ApiParam(value = "회원 아이디", required = true)
                         @RequestParam String uid,
                                   @ApiParam(value = "회원 이름", required = true)
                         @RequestParam String name) {
        User user = User.builder()
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));

    }

    @ApiOperation(value = "회원 삭제", notes = "UserId로 회원을 삭제 한다.")
    @DeleteMapping(value = "/user/{msrl}")
    public CommonResult delete(@ApiParam(value = "회원 번호", required = true) @PathVariable Long msrl) {
        userJpaRepo.deleteById(msrl);
        return responseService.getSuccessResult();
    }

}
