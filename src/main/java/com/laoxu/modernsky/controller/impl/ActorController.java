package com.laoxu.modernsky.controller.impl;

import com.laoxu.modernsky.bll.AbsSuperService;
import com.laoxu.modernsky.bll.impl.ActorServiceImpl;
import com.laoxu.modernsky.bll.impl.ClassesServiceImpl;
import com.laoxu.modernsky.controller.AbsSuperController;
import com.laoxu.modernsky.controller.inter.IActor;
import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value ="/actor",method = RequestMethod.POST)
public class ActorController extends AbsSuperController implements IActor {
    @Autowired
    private ActorServiceImpl bll;

    @Autowired
    private Actor actor;

    @Override
    public AbsSuperService getService() {
        setModel(actor);
        return bll;
    }

    @Override
    @RequestMapping(value = "selectAId", method = RequestMethod.POST)
    @ResponseBody
    public BackReturn selectAId(@RequestBody Map<String,Object> object) {
        BackReturn back = bll.selectAId(object);
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
    @RequestMapping(value = "deleteActor", method = RequestMethod.POST)
    @ResponseBody
    public BackReturn deleteActor(@RequestBody Map<String,Object> object) {
        BackReturn back = bll.deleteActor(object);
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
    @RequestMapping(value = "batchSelectActor", method = RequestMethod.POST)
    @ResponseBody
    public BackReturn batchSelectActor(@RequestBody String ids) {
        BackReturn back = new BackReturn();
        try {
            return bll.batchSelectActor(ids);
        } catch (Exception e) {
            back.setCode("202");
            back.setMessage("查询失败");
            back.setObj(null);
        }
        return back;
    }
}
