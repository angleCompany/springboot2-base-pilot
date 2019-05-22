package com.rest.api.service;

import com.rest.api.model.response.CommonResult;
import com.rest.api.model.response.ListResult;
import com.rest.api.model.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 해당 Class가 서비스임을 명시함.
public class ResponseService {

    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다."),
        FAIL(-1, "실패하였습니다.");

        Integer code;
        String msg;

        CommonResponse(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    // 단일건으로 결과를 처리하는 메서드
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 다중건 결과를 처리하는 메서드
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> listResult = new ListResult<>();
        listResult.setList(list);
        setSuccessResult(listResult);
        return listResult;
    }

    // 성공 결과만 처리하는 메서드
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }
    // 실패 결과만 처리하는 메서드드
    public CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
        return result;
    }

    // 결과 모델에 API 요청 성공 데이터를 세팅해주는 메서드
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

}
