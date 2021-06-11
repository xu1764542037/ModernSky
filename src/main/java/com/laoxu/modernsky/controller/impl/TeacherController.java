package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.StudentServiceImpl;
import com.laoxu.modernsky.bll.impl.TeacherServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.entity.Student;
import com.laoxu.modernsky.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping(value ="/teacher",method = RequestMethod.POST)
public class TeacherController extends AbsSuperController {
    @Autowired
    private TeacherServiceImpl bll;

    @Autowired
    private Teacher teacher;

    @Override
    public AbsSuperService getService() {
        setModel(teacher);
        return bll;
    }
}
