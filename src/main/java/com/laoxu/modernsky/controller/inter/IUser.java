package com.laoxu.modernsky.controller.inter;

import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.UserAndActor;

import java.util.Map;

public interface IUser {
    BackReturn setActor(Map<String,Object> object);
}
