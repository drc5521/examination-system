package com.drc.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drc.bean.Questions;
import com.drc.mapper.QuestionsMybatisPlusMapper;
import com.drc.mapper.StudentMybatisPlusMapper;
import com.drc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private QuestionsMybatisPlusMapper questionsMybatisPlusMapper;
    @Autowired
    StudentMybatisPlusMapper studentMybatisPlusMapper;



    /**
     * 分页处理
     * @param PageId 前端传入的页码
     * @return
     */
    @Override
    public HashMap<String, Object>  page(Integer PageId) {
        Page<Questions> page = new Page<>(PageId, 20);
        QueryWrapper<Questions> wrapper = new QueryWrapper<>(new Questions(), "qid", "stem", "options","answer", "analysis");
        questionsMybatisPlusMapper.selectPage(page, wrapper);
        List<Questions> questionsPage = page.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        if (page.getRecords().size()>0){
            map.put("code",200);
            map.put("data",questionsPage);
        }else {
            map.put("code",400);
        }

        return map;
    }


    //查询试题总数
    @Override
    public int questionsCount() {
        return questionsMybatisPlusMapper.selectCount(null);
    }


    //查询学生总数
    @Override
    public int studentCount() {
        return studentMybatisPlusMapper.selectCount(null);
    }
}
