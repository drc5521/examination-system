package com.drc.bean;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nh.micro.ext.ExtBeanWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


// 试题
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer qid;
    private String stem;

    // @JSONField(name = "options")
    private ExtBeanWrapper options;


    private String answer;
    private String analysis;
    private Integer tid;
    //可以不写，不写的话，就不会向前端传输这个字段的数据
    private Integer cid;
    private Integer sid;
}
