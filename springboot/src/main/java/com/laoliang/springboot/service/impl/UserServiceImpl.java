package com.laoliang.springboot.service.impl;

import com.laoliang.springboot.aop.TimePrint;
import com.laoliang.springboot.pojo.bo.User;
import com.laoliang.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author laoliangliang
 * @date 2019/10/30 13:47
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @TimePrint
    @Override
    @Cacheable(value = "userList")
    public List<User> getAll() {
        log.info("=====> " + this.getClass().getSimpleName() + ":getAll 进入");
        //aop不起作用
        log.info(getOne().toString());
        return Arrays.asList(
                new User(1L, "小A", "15064561234"),
                new User(2L, "小B", "15064561235"),
                new User(3L, "小C", "15064561236"));
    }

    @TimePrint
    @Override
    public User getOne() {
        return new User(4L, "小C", "15064561236");
    }
}
