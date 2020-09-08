package com.drc.mapper;


/**
 * 查询总数量
 */
public interface SelectCountMapper {

    // 查询试题总数
    public int questionsCount();

    // 查询所有用户总数
    public int userCount();
}
