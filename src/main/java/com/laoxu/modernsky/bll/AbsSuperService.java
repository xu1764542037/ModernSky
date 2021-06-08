package com.laoxu.modernsky.bll;

import com.laoxu.modernsky.dao.inter.IDoDate;
import com.laoxu.modernsky.entity.AbsSuperObject;
import com.laoxu.modernsky.entity.BackReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbsSuperService {

    //定义数据访问层抽象方法
    public abstract IDoDate getDao();

    /**
     * 条件检测方法
     */
    private BackReturn checkCondition(AbsSuperObject obj){
        //定义结果
        BackReturn back = new BackReturn();
        if (obj==null || getDao()==null){
            back.setCode("000");
            back.setMessage("系统检测到数据访问层对象为空或者操作参数为空！");
            back.setObj(false);
        }else {
            back.setCode("100");
            back.setMessage("系统参数检查通过！");
            back.setObj(true);
        }
        return back;
    }

    /**
     * 新增
     */
    public BackReturn add(AbsSuperObject obj){
        BackReturn back = checkCondition(obj);//检查参数
        if ((Boolean) back.getObj()==false) {
            return back;
        }
        //调用数据访问层新增功能
        int result = getDao().add(obj);
        if (result>0){
            back.setCode("200");
            back.setMessage("新增成功");
        }else {
            back.setCode("002");
            back.setMessage("新增失败");
        }
        back.setObj(result);
        return back;
    }

    /**
     * 修改
     * @param obj
     * @return
     */
    public BackReturn update(AbsSuperObject obj){
        BackReturn back = checkCondition(obj);//检查参数
        if ((Boolean) back.getObj()==false) {
            return back;
        }
        //调用数据访问层新增功能
        int result = getDao().update(obj);
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

    /**
     * 删除
     * @param obj
     * @return
     */
    public BackReturn delete(AbsSuperObject obj){
        BackReturn back = checkCondition(obj);//检查参数
        if ((Boolean) back.getObj()==false) {
            return back;
        }
        //调用数据访问层新增功能
        int result = getDao().delete(obj);
        if (result>0){
            back.setCode("200");
            back.setMessage("删除成功");
        }else {
            back.setCode("002");
            back.setMessage("删除失败");
        }
        back.setObj(result);
        return back;
    }

    /**
     * 查找
     */
    public BackReturn select(){
        BackReturn back = new BackReturn();//检查参数
        if (getDao()==null) {
            back.setCode("000");
            back.setMessage("数据访问层对象为空");
            back.setObj(null);
            return back;
        }
        //调用数据访问层查找功能
        List<AbsSuperObject> select = getDao().select();
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




}
