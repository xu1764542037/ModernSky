package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.IslandServiceImpl;
import com.laoxu.modernsky.bll.impl.StudentServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.entity.Island;
import com.laoxu.modernsky.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping(value ="/student",method = RequestMethod.POST)
public class StudentController extends AbsSuperController {
    @Autowired
    private StudentServiceImpl bll;

    @Autowired
    private Student student;

    @Override
    public AbsSuperService getService() {
        setModel(student);
        return bll;
    }
}
