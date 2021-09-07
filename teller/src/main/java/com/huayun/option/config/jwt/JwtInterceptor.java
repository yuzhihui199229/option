package com.huayun.option.config.jwt;

import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.utils.JsonUtil;
import com.huayun.option.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token.length()>0) {
            if (JwtUtil.verify(token)) {
                return true;
            }
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JsonUtil.objectToJson(new Result(CodeMessage.TOKEN_ERROR.getCode(), CodeMessage.TOKEN_ERROR.getMessage())));
        return false;
    }
}
