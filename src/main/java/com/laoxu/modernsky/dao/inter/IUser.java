package com.laoxu.modernsky.dao.inter;

import com.laoxu.modernsky.entity.Actor;
import com.laoxu.modernsky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUser extends IDoDate{
    /**
     * 设置权限
     * @param user
     * @param actor
     * @return
     */
    int setActor(User user, Actor actor);
}
