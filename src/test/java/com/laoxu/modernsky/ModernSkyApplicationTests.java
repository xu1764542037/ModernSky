package com.laoxu.modernsky;

import com.laoxu.modernsky.dao.inter.*;
import com.laoxu.modernsky.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Student student;

    @Autowired
    private Island island;


    @Autowired
    private IUser iUser;

    @Autowired
    private IClasses iClasses;

    @Autowired
    private IStudent iStudent;

    @Autowired
    private IActor iActor;

    @Autowired
    private IIsland iIsland;

    @Test
    void contextLoads() {

    }

    @Test
    void test1() {
        user.setId("xu123456");
        actor.setId("3");
        iUser.setActor(user,actor);
    }

    @Test
    void test2() {
        user.setId("xu1764542037");
        System.out.println(iActor.selectAId(user));
    }

    @Test
    void test3() {
        Map<String,Object> map = new HashMap<>();
        map.put("column","className");
        map.put("major","软件技术");
        System.out.println(iClasses.distinctSelect(map));
    }

    @Test
    void test4() {
        Map<String,Object> map = new HashMap<>();
        map.put("id","xu123456");
        System.out.println(iStudent.select(map));
    }

    @Test
    void test5() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","管理员");
        System.out.println(iActor.select(map));
    }

    @Test
    void test6() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(iActor.batchSelectActor(list));
    }

    @Test
    void test7() {
        user.setId("admin");
        System.out.println(iIsland.selectIId(user));

    }

    @Test
    void test8() {
        user.setId("admin");
        island.setId("11");
        System.out.println(iIsland.joinIsland(user,island));
    }

    @Test
    void test9() {
        user.setId("admin");
        island.setId("11");
        System.out.println(iIsland.exitIsland(user,island));

    }
}
