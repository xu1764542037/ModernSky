package com.laoxu.modernsky.bll.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.dao.inter.IClasses;
import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.dao.inter.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class StudentServiceImpl extends AbsSuperService {
    @Autowired
    private IStudent dao;

    @Override
    public IDoDate getDao() {
        return dao;
    }
}
