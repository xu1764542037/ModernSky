package com.laoxu.modernsky.bll.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.dao.inter.IActor;
import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class ActorServiceImpl extends AbsSuperService implements com.laoxu.modernsky.bll.inter.IActor {
    @Autowired
    private IActor dao;

    @Autowired
    User user;

    @Override
    public IDoDate getDao() {
        return dao;
    }

    @Override
    public BackReturn selectAId(Map<String,Object> cons){
        BackReturn back = new BackReturn();//检查参数
        if (getDao()==null) {
            back.setCode("000");
            back.setMessage("数据访问层对象为空");
            back.setObj(null);
            return back;
        }
        String id = (String) cons.get("id");
        user.setId(id);
        //调用数据访问层查找功能
        List<Object> select = dao.selectAId(user);
        if (select!=null){
            back.setCode("200");
            back.setMessage("查找成功");

        }else {
            back.setCode("002");
            back.setMessage("查找失败");
        }
        back.setObj(select);
        return back;
    }

    @Override
    public BackReturn deleteActor(Map<String, Object> cons) {
        BackReturn back = new BackReturn();//检查参数
        if (getDao()==null) {
            back.setCode("000");
            back.setMessage("数据访问层对象为空");
            back.setObj(null);
            return back;
        }
        String id = (String) cons.get("id");
        user.setId(id);
        //调用数据访问层查找功能
        int result = dao.deleteActor(user);
        if (result>0){
            back.setCode("200");
            back.setMessage("修改成功");
        }else {
            back.setCode("002");
            back.setMessage("修改失败");
        }
        back.setObj(result);
        return back;
    }

    @Override
    public BackReturn batchSelectActor(String ids) {
        BackReturn back = new BackReturn();
        if (back == null) {
            back.setCode("000");
            back.setMessage("系统检测到数据访问层对象为空或者操作参数为空！");
            back.setObj(null);
            return back;
        }
        System.out.println(ids);
        String[] idList = ids.split("-");
        List<String> array = new ArrayList<>();
        int idNum = idList.length-2;
        for (int i=1; i<= idNum; i++){
            array.add(idList[i]);
        }
        List<Object> result = dao.batchSelectActor(array);
        if (result != null){
            back.setCode("200");
            back.setMessage("查询成功");
        }else {
            back.setCode("002");
            back.setMessage("查询失败");
        }
        back.setObj(result);
        return back;
    }
}

