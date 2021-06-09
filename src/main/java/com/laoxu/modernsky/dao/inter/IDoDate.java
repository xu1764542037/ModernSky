package com.laoxu.modernsky.dao.inter;

import com.laoxu.modernsky.entity.AbsSuperObject;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IDoDate {
    int add(AbsSuperObject obj);
    int update(AbsSuperObject obj);
    int delete(AbsSuperObject obj);
    List<AbsSuperObject> select();


    List<AbsSuperObject> login(Map<String, Object> cons);

}
