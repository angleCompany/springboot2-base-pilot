package com.rest.api.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rest.api.entity.User;
import com.rest.api.repo.UserJpaRepo;

//@RequiredArgsConstructor ..//class상단에 선언하면 class내부에 final로 선언된 객체에 대해서 Constructor Injection을 수행합니다. 해당 어노테이션을 사용하지 않고 선언된 객체에 @Autowired를 사용해도 됩니다.
@RestController // 결과 데이터를 JSON으로 내보냅니다.
@RequestMapping(value = "/v1")
public class UserController  {
    @Autowired
    UserJpaRepo userJpaRepo;

    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userJpaRepo.findAll();
    }

    @PostMapping(value = "/user")
    public User save() {
        User user = User.builder()
                .uid("zuurcode@gmail.com")
                .name("이승주")
                .build();
        return userJpaRepo.save(user);

    }

}
