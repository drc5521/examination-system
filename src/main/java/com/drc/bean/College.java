package com.drc.bean;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 学院实体类
 */
@Data
public class College implements Serializable {

    @ApiModelProperty("学院id")
    private int cid;

    @ApiModelProperty("学院名称")
    private String name;
}
