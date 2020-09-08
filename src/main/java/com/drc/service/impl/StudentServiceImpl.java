package com.drc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drc.bean.Questions;
import com.drc.mapper.GetQuestions;
import com.drc.mapper.QuestionsMybatisPlusMapper;
import com.drc.mapper.StudentMybatisPlusMapper;
import com.drc.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.jfunc.common.converter.DefaultJsonConverter;
import top.jfunc.common.converter.JsonConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    private QuestionsMybatisPlusMapper questionsMybatisPlusMapper;

    @Autowired
    private StudentMybatisPlusMapper studentMybatisPlusMapper;

    @Autowired
    private GetQuestions getQuestions;

    private Integer subjectKindInt;
    private Integer collegeKindInt;

    @Override
    public Map<String, Object> getQuestions(String collegeKind,Integer subjectKind) {
        QueryWrapper<Questions> wrapper = new QueryWrapper<>(new Questions(), "qid", "stem", "options","answer", "analysis");
        switch (collegeKind){
                // 马克思主义学院
            case "marxism" : collegeKindInt = 1;break;
                // 生命科学学院
            case "sciences" : collegeKindInt = 2;break;
                // 法学院
            case "law" : collegeKindInt = 3;break;
                // 教师教育学院
            case "education" : collegeKindInt = 4;break;
                // 化学化工学院
            case "chemical" : collegeKindInt = 5;break;
                // 生态与资源学院
            case "ecology" : collegeKindInt = 6;break;
                // 文学与新闻传播学院
            case "literature" : collegeKindInt = 7;break;
                // 能源与机械学院
            case "energy" : collegeKindInt = 8;break;
                // 医药与护理学院
            case "medicine" : collegeKindInt = 9;break;
                // 音乐学院
            case "music" : collegeKindInt = 10;break;
                // 物理与电子信息学院
            case "physics" : collegeKindInt = 11;break;
                // 纺织服装学院
            case "clothing" : collegeKindInt = 12;break;
                // 体育学院
            case "physical" : collegeKindInt = 13;break;
                // 计算机与信息学院
            case "computer" : collegeKindInt = 14;break;
                // 外国语学院
            case "foreign" : collegeKindInt = 15;break;
                // 美术学院
            case "academy" : collegeKindInt = 16;break;
                // 经济管理学院
            case "management" : collegeKindInt = 17;break;
                // 数学与大数据学院
            case "mathematics" : collegeKindInt = 18;break;


        }
        wrapper.eq("sid",subjectKind)
                .eq("cid",collegeKindInt);
        System.out.println(collegeKindInt);
        List<Questions> questions = questionsMybatisPlusMapper.selectList(wrapper);
        // List<Questions> questions = getQuestions.selectQuestions(collegeKindInt,subjectKind);
        Map<String, Object> map = new HashMap<>();
        if (questions.size()>0){
            map.put("code",200);
            map.put("data",questions);
        }else {
            map.put("code",400);
        }


        Object user1 = redisTemplate.opsForValue().get("user");
        System.out.println(questions);
        return map;
    }

}
