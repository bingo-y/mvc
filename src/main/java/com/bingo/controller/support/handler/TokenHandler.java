package com.bingo.controller.support.handler;

import com.bingo.controller.support.msg.MessageErrorCode;
import com.bingo.controller.support.msg.MessageException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class TokenHandler implements HandlerMethodArgumentResolver {
    private static final String TOKEN = "token";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Token token = methodParameter.getParameterAnnotation(Token.class);
        if (token != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String tokenParam = nativeWebRequest.getParameter(TOKEN);
        if (tokenParam == null || "".equals(tokenParam.trim())) {
            return new MessageException(MessageErrorCode.TOKEN_INVALID, String.format("参数%s不能为空", TOKEN));
        }
        return tokenParam;
    }


}
