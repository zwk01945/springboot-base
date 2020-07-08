package com.example.thread.dao;

import com.example.thread.bean.CoustomerZt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CoustomerZtDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CoustomerZt record);

    int insertSelective(CoustomerZt record);

    CoustomerZt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoustomerZt record);

    int updateByPrimaryKey(CoustomerZt record);

    long insertList(@Param("ztList") List<CoustomerZt> ztList);

    List<CoustomerZt> selectAll(Map<String,Object> map);

    long selectCount();
}