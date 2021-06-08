package com.laoxu.modernsky.bll.impl;


import org.springframework.stereotype.Service;
import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.dao.inter.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl extends AbsSuperService {
    @Autowired
    private IUser dao;

    @Override
    public IDoDate getDao() {
        return dao;
    }

}
