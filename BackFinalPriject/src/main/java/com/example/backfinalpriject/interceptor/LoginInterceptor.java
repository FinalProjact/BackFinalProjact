package com.example.backfinalpriject.interceptor;

import com.example.backfinalpriject.admin.strategy.service.StrategyService;
import com.example.backfinalpriject.exception.ErrorCode;
import com.example.backfinalpriject.exception.GlobalException;
import com.example.backfinalpriject.member.dto.request.MemberLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {





    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
            throws Exception {

       HttpSession session = request.getSession();
        MemberLoginRequest email = (MemberLoginRequest) session.getAttribute("email");

        if(email == null){
            log.info("관리자 로그인 해야 이용 가능 합니다");
            response.sendRedirect("/admin/login");
             return false;
        }
            return true;
    }
}
