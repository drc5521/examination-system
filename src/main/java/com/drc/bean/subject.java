package com.drc.bean;

import lombok.Data;

import java.io.Serializable;


//科目
@Data
public class subject implements Serializable {
    private Integer sid;
    private String name;//科目名称
}
