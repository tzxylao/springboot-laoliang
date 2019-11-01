package com.laoliang.springboot.service;

import com.laoliang.springboot.pojo.bo.User;

import java.util.List;

/**
 * @author laoliangliang
 * @date 2019/10/30 13:44
 */
public interface UserService {

    List<User> getAll();

    User getOne();
}
