package com.atguigu.security.security;

import com.atguigu.utils.utils.R;
import com.atguigu.utils.utils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  当用户请求了一个受保护的资源，但是用户没有通过认证，那么抛出异常，AuthenticationEntryPoint. Commence(..)就会被调用
 */
public class UnauthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.out(httpServletResponse, R.error());
    }
}
