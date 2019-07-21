package com.yuanfy.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author maple.yuan
 * @date 2019-07-20 15:43
 */
@Data
public class UserEntity extends Person {
    private Date createTime;
    private Double money;

    public static Integer id = 10;
}
