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

    List<AbsSuperObject> selectIdAndPwd(Map<String, Object> cons);

    List<AbsSuperObject> selectId(Map<String, Object> cons);

    List<AbsSuperObject> selectByCondition(Map<String, Object> cons);


    List<AbsSuperObject> selectClassName();

    List<AbsSuperObject> selectDepartment();

    List<AbsSuperObject> selectStatus();


    int batchDelete(List<String> id);

    int batchAll(Map<String ,Object> cons);
}
