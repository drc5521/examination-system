package com.drc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.drc.bean.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubjectMapper extends BaseMapper<Subject> {
    //查询科目
    @Select("select * from subject")
    public List<Subject> selectSubject();
}
