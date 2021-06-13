package com.laoxu.modernsky.bll.inter;


import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.BackReturn;
import com.laoxu.modernsky.entity.User;
import com.laoxu.modernsky.entity.UserAndActor;

public interface IUser {
    BackReturn setActor(User user, Actor actor);
}
