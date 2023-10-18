package com.example.app.auth.loginHandler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        System.out.println("로그인 실패! : " + exception);
        System.out.println("로그인 실패! MSG : " + exception.getMessage());

        response.sendRedirect(request.getContextPath()+"/login?error="+exception.getMessage());
    }
}