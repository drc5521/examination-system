package com.drc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.drc.bean.Questions;
import com.drc.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 利用MybatisPlus插件
 */
public interface StudentMybatisPlusMapper extends BaseMapper<Student> {

    public List<Questions> selectQuestions(int subjectKind, int collegeKindInt);


}
