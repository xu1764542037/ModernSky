package com.laoxu.modernsky.controller.inter;

import com.laoxu.modernsky.entity.BackReturn;

import java.util.Map;

public interface IIsland {
    BackReturn selectIId(Map<String,Object> cons);

    BackReturn batchSelectIsland(String ids);

    BackReturn joinIsland(Map<String,Object> cons);

    BackReturn exitIsland(Map<String,Object> cons);

}
