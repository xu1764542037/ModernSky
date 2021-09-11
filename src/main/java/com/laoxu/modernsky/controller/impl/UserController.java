package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.UserServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.controller.inter.IUser;
import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value ="/user",method = RequestMethod.POST)
public class UserController extends AbsSuperController implements IUser {
    @Autowired
    private UserServiceImpl bll;

    @Autowired
    private User user;

    @Autowired
    private Actor actor;

    @Override
    public AbsSuperService getService() {
        setModel(user);
        return bll;
    }

    @Override
    @RequestMapping(value = "setActor", method = RequestMethod.POST)
    public BackReturn setActor(@RequestBody Map<String,Object> object) {
        user.setId(object.get("user").toString());
        actor.setId(object.get("actor").toString());
       return  bll.setActor(user,actor);

//        return null;
    }


}
