package com.rest.api.advice;

import javax.servlet.http.HttpServletRequest;

import com.rest.api.advice.exception.CEmailSigninFailException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.rest.api.advice.exception.CUserNotFoundException;
import com.rest.api.model.response.CommonResult;
import com.rest.api.service.ResponseService;

import lombok.RequiredArgsConstructor;
import sun.misc.CEFormatException;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.msg"));
    }

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(Integer.valueOf(getMessage("userNotFound.code")), getMessage("userNotFound.msg"));
    }

    @ExceptionHandler(CEmailSigninFailException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult emailSigninFailed(HttpServletRequest request, CEmailSigninFailException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("emailSigninFailed.code")), getMessage("emailSigninFailed.msg"));
    }

    // code정보에 해당하는 메시지를 조회합니다.
    private String getMessage(String code) {
        return getMessage(code, null);
    }
    // code정보, 추가 argument로 현재 locale에 맞는 메시지를 조회합니다.
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }


}
