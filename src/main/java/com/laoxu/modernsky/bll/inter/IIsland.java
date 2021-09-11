package com.laoxu.modernsky.bll.inter;

import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.Island;
import com.laoxu.modernsky.entity.User;

import java.util.Map;

public interface IIsland {
    BackReturn selectIId(Map<String,Object> cons);

    BackReturn batchSelectIsland(String ids);

    BackReturn joinIsland(User user, Island island);

    BackReturn exitIsland(User user, Island island);
}
