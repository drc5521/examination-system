package com.drc.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drc.bean.*;
import com.drc.mapper.*;
import com.drc.service.AdminService;
import com.nh.micro.ext.ExtBeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private QuestionsMybatisPlusMapper questionsMybatisPlusMapper;

    @Autowired
    private StudentMybatisPlusMapper studentMybatisPlusMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private SelectMapper selectMapper;



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


    //查询学院
    @Override
    public List selectCollege() {
        // QueryWrapper<College> wrapper = new QueryWrapper<>(new College(), "name");

        List selectCollege = collegeMapper.selectList(null);

        // System.out.println(selectCollege);
        return selectCollege;
    }

    //查询科目
    @Override
    public List<Subject> selectSubject() {
        return subjectMapper.selectSubject();
    }


    /**
     * 向数据库中添加试题
     * @param addQuestion
     */
    @Override
    public void addQuestions(AddQuestion addQuestion) {
        /*ExtBeanWrapper extBeanWrapper = new ExtBeanWrapper();
        HashMap<String, Object> map = new HashMap<>();
        String string = "";*/
        String string2 = "";
        String[] options = addQuestion.getOptions();
        int op;
        String opS = null;
        StringBuffer stringBuffer = new StringBuffer();
        for (op = 0; op < options.length; op++) {
            switch (op) {
                case 0:
                    opS = "A";
                    break;
                case 1:
                    opS = "B";
                    break;
                case 2:
                    opS = "C";
                    break;
                case 3:
                    opS = "D";
                    break;
                case 4:
                    opS="E";break;
            }

            if (op>0){
                stringBuffer.append(",");
            }
            stringBuffer.append("\""+opS+"\"" + ":" + "\""+options[op]+"\"");

        }

        // {"A":"123","B":"BBB","C":"CCC"}

        string2 += "{" + stringBuffer + "}";
        // System.out.println(stringBuffer);

        System.out.println(string2);
        Question question = new Question(addQuestion.getQid(),addQuestion.getStem(),string2,addQuestion.getAnswer(),addQuestion.getAnalysis(),addQuestion.getTid(),addQuestion.getCid(),addQuestion.getSid());
        System.out.println(question);
        questionMapper.addQuestions(question);
        // questionMapper.insert(question);

    }

    /**
     * 查询试题类型（单选多选判断）
     * @return
     */
    @Override
    public List<questionType> selectType() {
        List selectType = selectMapper.selectType();
        return selectType;
    }


}
