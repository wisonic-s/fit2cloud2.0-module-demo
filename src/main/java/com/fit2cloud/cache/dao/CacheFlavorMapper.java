package com.fit2cloud.cache.dao;

import com.fit2cloud.cache.domain.CacheFlavor;
import com.fit2cloud.cache.domain.CacheFlavorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CacheFlavorMapper {
    long countByExample(CacheFlavorExample example);

    int deleteByExample(CacheFlavorExample example);

    int deleteByPrimaryKey(String id);

    int insert(CacheFlavor record);

    int insertSelective(CacheFlavor record);

    List<CacheFlavor> selectByExample(CacheFlavorExample example);

    CacheFlavor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CacheFlavor record, @Param("example") CacheFlavorExample example);

    int updateByExample(@Param("record") CacheFlavor record, @Param("example") CacheFlavorExample example);

    int updateByPrimaryKeySelective(CacheFlavor record);

    int updateByPrimaryKey(CacheFlavor record);
}