package com.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @program: test
 * @description 用户类
 * @author: w
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/

@Data
public class User {
    private String id;
    private String name;
    private String password;
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
    private Integer version;
    @TableLogic
    private Integer deleted;
}
