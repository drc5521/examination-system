package com.drc.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question implements Serializable{

        private Integer qid;
        private String stem;
        private String options;
        private String answer;
        private String analysis;
        private Integer tid;
        private Integer cid;
        private Integer sid;

}
