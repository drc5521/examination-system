package com.drc.controller;


import com.drc.bean.AddQuestion;
import com.drc.bean.College;
import com.drc.bean.Questions;
import com.drc.mapper.QuestionsMybatisPlusMapper;
import com.drc.mapper.StudentMybatisPlusMapper;
import com.drc.service.AdminService;
import com.nh.micro.ext.ExtBeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
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


    private ExtBeanWrapper ExtBeanOptions;



    /**
     * 查询试题总数和学生总数，首页
     * @param session
     * @return
     */
    @GetMapping({"/","index"})
    public String welcome(HttpSession session){
        //查询试题总数
        int questionsCount = adminService.questionsCount();
        //查询学生总数
        int studentCount = adminService.studentCount();
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

    /**
     * 查询科目和学院和试题类型
     * @return
     */
    @GetMapping("/admin/questions-add")
    public String selectCollegeAndSubject(Model model,HttpSession session){

        List collegeList = adminService.selectCollege();
        List selectSubject = adminService.selectSubject();
        List selectType = adminService.selectType();
        session.setAttribute("collegeList",collegeList);
        session.setAttribute("selectSubject",selectSubject);
        session.setAttribute("selectTypes",selectType);
        return "/admin/questions-add";
    }

    /**
     * 添加试题
     * @param addQuestion
     * @return
     */
    @PostMapping("/admin/questions-add")
    public String addQuestions(AddQuestion addQuestion){
        adminService.addQuestions(addQuestion);
        return "/admin/questions-add";
    }


}
