package com.laoxu.modernsky.bll.inter;

import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.BackReturn;

import java.util.List;
import java.util.Map;

public interface IActor {
    BackReturn selectAId(Map<String,Object> cons);

    BackReturn deleteActor(Map<String,Object> cons);

    BackReturn batchSelectActor(String ids);
}
