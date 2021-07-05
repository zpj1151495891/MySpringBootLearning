package com.didispace.chapter51;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter51ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() throws Exception {
        // 创建1条记录
        userRepository.save(new User("AAA", 10));

        TimeInterval timeInterval = DateUtil.timer();

        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge()+";用时:"+timeInterval.intervalMs());

        timeInterval.restart();
        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge()+";用时:"+timeInterval.intervalMs());

        timeInterval.restart();
        User u3 = userRepository.findByName("BBB");
        System.out.println("第三次查询" + ";用时:"+timeInterval.intervalMs());

        userRepository.deleteById(u1.getId());

        timeInterval.restart();
        User u4 = userRepository.findByName("AAA");
        System.out.println("第四次查询:"+";用时:"+timeInterval.intervalMs());
    }

}
