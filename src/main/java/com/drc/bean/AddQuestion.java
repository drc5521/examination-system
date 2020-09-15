package com.drc.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nh.micro.ext.ExtBeanWrapper;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddQuestion  implements Serializable {

        @TableId(type = IdType.AUTO)
        private Integer qid;
        private String stem;

        // @JSONField(name = "options")
        private String[] options;


        private String answer;
        private String analysis;

        private Integer tid;

        //可以不写，不写的话，就不会向前端传输这个字段的数据
        private Integer cid;
        private Integer sid;
}
