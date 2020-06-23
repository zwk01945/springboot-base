package com.example.thread.dao;

import com.example.thread.bean.CoustomerZt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoustomerZtDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CoustomerZt record);

    int insertSelective(CoustomerZt record);

    CoustomerZt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoustomerZt record);

    int updateByPrimaryKey(CoustomerZt record);

    long insertList(@Param("ztList") List<CoustomerZt> ztList);
}