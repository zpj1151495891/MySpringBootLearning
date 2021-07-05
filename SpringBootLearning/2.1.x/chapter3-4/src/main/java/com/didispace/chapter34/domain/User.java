package com.didispace.chapter34.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    @Max(50)
    private Integer age;

    /**
     * 
     */
    @Size(max = 5)
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public User(String name,Integer age){
        this.age = age;
        this.name = name;
    }
}