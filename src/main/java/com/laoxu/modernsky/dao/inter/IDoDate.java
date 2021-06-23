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
    List<AbsSuperObject> select(Map<String, Object> cons);



    List<AbsSuperObject> selectActorId(Map<String, Object> cons);

    List<AbsSuperObject> distinctSelect(Map<String,Object> cons);

    //分页查找
    List<Map<String,Object>> findByPage(Map<String,Object> cons);

    //查找符合条件的记录总行数
    int rowsCount(Map<String,Object> cons);

}
