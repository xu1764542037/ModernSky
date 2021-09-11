package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.ClassesServiceImpl;
import com.laoxu.modernsky.bll.impl.IslandServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.controller.inter.IIsland;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.Classes;
import com.laoxu.modernsky.entity.Island;
import com.laoxu.modernsky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value ="/island",method = RequestMethod.POST)
public class IslandController extends AbsSuperController implements IIsland {
    @Autowired
    private IslandServiceImpl bll;


    @Autowired
    private User user;


    @Autowired
    private Island island;

    @Override
    public AbsSuperService getService() {
        setModel(island);
        return bll;
    }

    @Override
    @RequestMapping(value = "selectIId", method = RequestMethod.POST)
    @ResponseBody
    public BackReturn selectIId(@RequestBody Map<String,Object> object) {
        BackReturn back = bll.selectIId(object);
        if (back.getObj()!=null && back.getObj() instanceof List){
            List result = (List) back.getObj();
            if (result.size()>0){
                back.setObj(result);
            }else {
                back.setObj(null);
            }
            return back;
        }else {
            return back;
        }
    }

    @Override
    @RequestMapping(value = "batchSelectIsland", method = RequestMethod.POST)
    @ResponseBody
    public BackReturn batchSelectIsland(@RequestBody String ids) {
        BackReturn back = new BackReturn();
        try {
            return bll.batchSelectIsland(ids);
        } catch (Exception e) {
            back.setCode("202");
            back.setMessage("查询失败");
            back.setObj(null);
        }
        return back;
    }

    @Override
    public BackReturn joinIsland(Map<String, Object> cons) {
        BackReturn back = new BackReturn();
        try {
            user.setId(cons.get("user_id").toString());
            island.setId(cons.get("island_id").toString());
            return  bll.joinIsland(user,island);
        } catch (Exception e) {
            back.setCode("202");
            back.setMessage("添加失败");
            back.setObj(null);
        }
        return back;
    }

    @Override
    public BackReturn exitIsland(Map<String, Object> cons) {
        BackReturn back = new BackReturn();
        try {
            user.setId(cons.get("user_id").toString());
            island.setId(cons.get("island_id").toString());
            return  bll.exitIsland(user,island);
        } catch (Exception e) {
            back.setCode("202");
            back.setMessage("添加失败");
            back.setObj(null);
        }
        return back;
    }
}
