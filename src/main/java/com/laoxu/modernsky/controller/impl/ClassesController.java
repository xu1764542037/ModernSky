package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.ClassesServiceImpl;
import com.laoxu.modernsky.bll.impl.UserServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.entity.Classes;
import com.laoxu.modernsky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping(value ="/classes",method = RequestMethod.POST)
public class ClassesController extends AbsSuperController {
    @Autowired
    private ClassesServiceImpl bll;

    @Autowired
    private Classes classes;

    @Override
    public AbsSuperService getService() {
        setModel(classes);
        return bll;
    }
}
