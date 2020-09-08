package com.drc.bean;


import lombok.Data;

import java.io.Serializable;

// 管理员
@Data
public class Admin implements Serializable {

    private Integer aid;
    private String name;//姓名
    private String studentNumber;//学号
    private String password;

}
