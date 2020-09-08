package com.drc.mapper;


import com.drc.bean.Questions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetQuestions {
    public List<Questions> selectQuestions(int subjectKind, int collegeKindInt);
}
