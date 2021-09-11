package com.laoxu.modernsky.bll.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.dao.inter.IClasses;
import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.dao.inter.IIsland;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.Island;
import com.laoxu.modernsky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class IslandServiceImpl extends AbsSuperService implements com.laoxu.modernsky.bll.inter.IIsland {
    @Autowired
    private IIsland dao;

    @Autowired
    User user;


    @Override
    public IDoDate getDao() {
        return dao;
    }

    @Override
    public BackReturn selectIId(Map<String,Object> cons){
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
        List<Object> select = dao.selectIId(user);
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
    public BackReturn batchSelectIsland(String ids) {
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
        List<Object> result = dao.batchSelectIsland(array);
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

    @Override
    public BackReturn joinIsland(User user, Island island) {
        BackReturn back=new BackReturn();
        //判断参数的有效性
        if (user==null || island==null) {
            back.setCode("0");
            back.setMessage("用户和岛都不能为空！");
            back.setObj(null);
            return back;
        }
        int result=dao.joinIsland(user,island);
        if (result>0){
            back.setCode("1");
            back.setMessage("用户关注岛成功！");
        }else{
            back.setCode("-1");
            back.setMessage("用户关注岛失败！");
        }
        back.setObj(result);
        return back;
    }

    @Override
    public BackReturn exitIsland(User user, Island island) {
        BackReturn back=new BackReturn();
        //判断参数的有效性
        if (user==null || island==null) {
            back.setCode("0");
            back.setMessage("用户和岛都不能为空！");
            back.setObj(null);
            return back;
        }
        int result=dao.exitIsland(user,island);
        if (result>0){
            back.setCode("1");
            back.setMessage("用户关注岛成功！");
        }else{
            back.setCode("-1");
            back.setMessage("用户关注岛失败！");
        }
        back.setObj(result);
        return back;
    }
}



