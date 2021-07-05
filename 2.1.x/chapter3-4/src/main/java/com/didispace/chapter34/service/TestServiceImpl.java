package com.didispace.chapter34.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.didispace.chapter34.domain.User;
import com.didispace.chapter34.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TestServiceImpl extends ServiceImpl<UserMapper,User> implements TestService {


    @Override
    @Transactional
    public void test1() {
        this.save(new User("AAA", 10));
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public void test2() {
        this.save(new User("AAA", 10));
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            log.error("异常捕获：", e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test3() {
        this.save(new User("AAA", 10));
        this.save(new User("1234567890", 20));
    }

    @Override
    @Transactional
    public void test4() {
        this.save(new User("AAA", 10));
        try {
            this.save(new User("1234567890", 20));
        } catch (Exception e) {
            log.error("异常捕获：", e);
        }
    }

    @Override
    public void test5() {
        try {
            this.save(new User("AAA", 10));
            this.save(new User("1234567890", 20));
        } catch (Exception e) {
            log.error("异常捕获：", e);
        }
    }


}
