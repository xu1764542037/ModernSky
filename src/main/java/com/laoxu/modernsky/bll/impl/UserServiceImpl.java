package com.laoxu.modernsky.bll.impl;


import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.User;
import org.springframework.stereotype.Service;
import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.dao.inter.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service
public class UserServiceImpl extends AbsSuperService implements com.laoxu.modernsky.bll.inter.IUser {
    @Autowired
    private IUser dao;

    @Override
    public IDoDate getDao() {
        return dao;
    }


    @Override
    public BackReturn setActor(User user, Actor actor) {
        BackReturn back=new BackReturn();
        //判断参数的有效性
        if (user==null || actor==null) {
            back.setCode("0");
            back.setMessage("用户和角色都不能为空！");
            back.setObj(null);
            return back;
        }
        int result=dao.setActor(user,actor);
        if (result>0){
            back.setCode("1");
            back.setMessage("用户角色分配成功！");
        }else{
            back.setCode("-1");
            back.setMessage("用户角色分配失败！");
        }
        back.setObj(result);
        return back;
    }
}
