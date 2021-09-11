package com.laoxu.modernsky.dao.inter;

import com.laoxu.modernsky.entity.Island;
import com.laoxu.modernsky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IIsland extends IDoDate {
    List<Object> selectIId(User user);

    List<Object> batchSelectIsland(List<String> ids);

    int joinIsland(User user, Island island);

    int exitIsland(User user, Island island);

}
