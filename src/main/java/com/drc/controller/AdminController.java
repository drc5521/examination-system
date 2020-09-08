package com.drc.controller;


import com.drc.bean.Questions;
import com.drc.mapper.QuestionsMybatisPlusMapper;
import com.drc.mapper.StudentMybatisPlusMapper;
import com.drc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    StudentMybatisPlusMapper studentMybatisPlusMapper;

    @Autowired
    QuestionsMybatisPlusMapper questionsMybatisPlusMapper;

    @Autowired
    AdminService adminService;


    @GetMapping({"/","index"})
    public String welcome(HttpSession session){
        //查询试题总数
        int questionsCount = adminService.questionsCount();
        //查询学生总数
        int studentCount = adminService.studentCount();
        System.out.println(questionsCount);
        session.setAttribute("questionsCount",questionsCount);
        session.setAttribute("studentCount",studentCount);
        return "/admin/index";
    }


    /**
     * 分页处理
     * @param PageId 前端传入的页码
     * @return
     */
    @GetMapping("/page/{PageId}")
    @ResponseBody
    public HashMap<String, Object> page(@PathVariable("PageId") Integer PageId, Model model){
        HashMap<String, Object> questionsList = adminService.page(PageId);
        return questionsList;

    }


}
