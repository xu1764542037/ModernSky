package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.UserServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.controller.inter.IUser;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.User;
import com.laoxu.modernsky.entity.UserAndActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping(value ="/user",method = RequestMethod.POST)
public class UserController extends AbsSuperController implements IUser {
    @Autowired
    private UserServiceImpl bll;

    @Autowired
    private User user;

    @Override
    public AbsSuperService getService() {
        setModel(user);
        return bll;
    }

    @Override
    @RequestMapping(value = "setActor", method = RequestMethod.POST)
    public BackReturn setActor(@RequestBody UserAndActor ua) {
        return bll.setActor(ua.getUser(),ua.getActor());
    }
}
