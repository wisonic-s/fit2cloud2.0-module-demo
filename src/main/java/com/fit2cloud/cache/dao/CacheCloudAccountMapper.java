package com.fit2cloud.cache.dao;

import com.fit2cloud.cache.domain.CacheCloudAccount;
import com.fit2cloud.cache.domain.CacheCloudAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CacheCloudAccountMapper {
    long countByExample(CacheCloudAccountExample example);

    int deleteByExample(CacheCloudAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(CacheCloudAccount record);

    int insertSelective(CacheCloudAccount record);

    List<CacheCloudAccount> selectByExample(CacheCloudAccountExample example);

    CacheCloudAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CacheCloudAccount record, @Param("example") CacheCloudAccountExample example);

    int updateByExample(@Param("record") CacheCloudAccount record, @Param("example") CacheCloudAccountExample example);

    int updateByPrimaryKeySelective(CacheCloudAccount record);

    int updateByPrimaryKey(CacheCloudAccount record);
}