package com.drc.controller;



import com.drc.bean.Questions;
import com.drc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 学生获取试题
     * @param subjectKind
     * @return
     */
    @PostMapping("/subject/{collegeKind}/{subjectKind}")
    @ResponseBody
    public Map<String, Object> getQuestions(@PathVariable("collegeKind") String collegeKind,
                               @PathVariable("subjectKind") Integer subjectKind,
                               Model model){
        Map<String, Object> questions = studentService.getQuestions(collegeKind, subjectKind);
        model.addAttribute("questions",questions);
        System.out.println(questions);
        System.out.println(collegeKind);
        System.out.println(subjectKind);
        return questions;
    }

}
