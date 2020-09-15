package com.drc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.drc.bean.AddQuestion;
import com.drc.bean.Question;
import com.drc.bean.Questions;

import java.util.List;

/**
 * 利用MybatisPlus插件
 */
public interface QuestionsMybatisPlusMapper extends BaseMapper<Questions> {

    // public int addQuestions(Question question);
}
