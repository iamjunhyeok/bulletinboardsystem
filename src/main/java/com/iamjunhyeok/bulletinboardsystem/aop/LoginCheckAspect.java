package com.iamjunhyeok.bulletinboardsystem.aop;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Log4j2
public class LoginCheckAspect  {

    @Around("@annotation(LoginCheck)")
    public Object loginCheck (ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();

        Long id = (Long) session.getAttribute("login");
        if (id == null) {
            log.error("loginCheck ERROR : {}", joinPoint.toString());
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "로그인 세션을 확인해주세요.") {};
        }

        return joinPoint.proceed();
    }
}
