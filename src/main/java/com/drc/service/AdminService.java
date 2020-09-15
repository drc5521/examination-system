package com.drc.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drc.bean.*;

import java.util.HashMap;
import java.util.List;

public interface AdminService {


    //分页

    /**
     *
     * @param PageId 前端传入的页码（第几页）
     */
    public HashMap<String, Object> page(Integer PageId);

    //查询试题总数
    public int questionsCount();

    //查询是、学生总数
    public int studentCount();

    //查询学院
    public List selectCollege();

    //查询科目
    public List<Subject> selectSubject();

    //添加试题
    public void addQuestions(AddQuestion AddQuestion);

    //查询试题类型（单选还是多选或者判断）
    public List<questionType> selectType();


}
