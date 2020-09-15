package com.drc.mapper;


import java.util.List;

/**
 * 查询总数量
 */
public interface SelectMapper {

    // 查询试题总数
    public int questionsCount();

    // 查询所有用户总数
    public int userCount();

    //查询试题的类型（单选还是多选或者判断）
    public List selectType();


}
