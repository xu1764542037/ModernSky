package com.laoxu.modernsky.dao.inter;

import com.laoxu.modernsky.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IActor extends IDoDate {
    List<Object> selectAId(User user);

    int deleteActor(User user);

    List<Object> batchSelectActor(List<String> ids);
}
