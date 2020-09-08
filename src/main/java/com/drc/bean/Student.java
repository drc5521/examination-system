package com.drc.bean;


import lombok.Data;

import java.io.Serializable;


// 学生
@Data
public class Student implements Serializable {

    private Integer stid;
    private String name;//姓名
    private String studentNumber;//学号
    private String password;
    private String email;
    private String college;//学院
    private Integer cid;
}
