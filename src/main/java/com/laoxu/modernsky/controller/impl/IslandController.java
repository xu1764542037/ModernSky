package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.ClassesServiceImpl;
import com.laoxu.modernsky.bll.impl.IslandServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.entity.Classes;
import com.laoxu.modernsky.entity.Island;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping(value ="/island",method = RequestMethod.POST)
public class IslandController extends AbsSuperController {
    @Autowired
    private IslandServiceImpl bll;

    @Autowired
    private Island island;

    @Override
    public AbsSuperService getService() {
        setModel(island);
        return bll;
    }
}
