package com.drc.config;



import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {


    //将查到的总试题数和总用户数数据带到前端
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        int questionsCount = (int) request.getSession().getAttribute("questionsCount");
        int studentCount = (int) request.getSession(). getAttribute("studentCount");
        request.setAttribute("questionsCount",questionsCount);
        request.setAttribute("studentCount",studentCount);
        System.out.println(questionsCount);
        return true;

    }
}