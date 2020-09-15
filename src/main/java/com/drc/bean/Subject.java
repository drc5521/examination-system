package com.drc.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


//科目
@Data
public class Subject implements Serializable {

    @ApiModelProperty("科目id")
    private Integer sid;

    @ApiModelProperty("科目名称")
    private String name;//科目名称
}
