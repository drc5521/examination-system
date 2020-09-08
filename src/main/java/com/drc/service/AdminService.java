package com.drc.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drc.bean.Questions;

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


}
