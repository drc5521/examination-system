package com.drc.service;

import com.drc.bean.Questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentService {

    //学生获取试题
    public Map<String, Object> getQuestions(String collegeKind, Integer subjectKind);
}
