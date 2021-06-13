package com.laoxu.modernsky;

import com.laoxu.modernsky.dao.inter.IClasses;
import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.dao.inter.IUser;
import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.Classes;
import com.laoxu.modernsky.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ModernSkyApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private Actor actor;

    @Autowired
    private Classes classes;

    @Autowired
    private IUser iUser;

    @Autowired
    private IClasses iClasses;


    @Test
    void contextLoads() {

    }

    @Test
    void test1() {
        user.setId("xu123456");
        actor.setId("1");
        iUser.setActor(user,actor);
    }

    @Test
    void test2() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","老师");
        System.out.println(iUser.selectActorId(map));
    }

    @Test
    void test3() {
        Map<String,Object> map = new HashMap<>();
        map.put("column","className");
        map.put("major","软件技术");
        System.out.println(iClasses.distinctSelect(map));
    }
}
