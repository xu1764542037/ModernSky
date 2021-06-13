package com.laoxu.modernsky.controller.inter;

import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.UserAndActor;

public interface IUser {
    BackReturn setActor(UserAndActor ua);
}
