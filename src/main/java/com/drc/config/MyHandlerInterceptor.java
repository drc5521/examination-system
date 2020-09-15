package com.drc.config;



import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {


    //将查到的总试题数和总用户数数据以及试题类型和所属学院和科目带到前端
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        int questionsCount = (int) request.getSession().getAttribute("questionsCount");
        int studentCount = (int) request.getSession(). getAttribute("studentCount");
        Object collegeList = request.getSession().getAttribute("collegeList");
        Object selectSubject = request.getSession().getAttribute("selectSubject");
        Object selectType = request.getSession().getAttribute("selectTypes");
        request.setAttribute("questionsCount",questionsCount);
        request.setAttribute("studentCount",studentCount);
        request.setAttribute("collegeList",collegeList);
        request.setAttribute("selectSubject",selectSubject);
        request.setAttribute("selectTypes",selectType);
        return true;

    }
}