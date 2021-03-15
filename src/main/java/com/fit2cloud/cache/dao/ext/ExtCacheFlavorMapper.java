package com.fit2cloud.cache.dao.ext;

import com.fit2cloud.cache.domain.CacheFlavor;
import com.fit2cloud.cache.domain.CacheFlavorExample;
import com.fit2cloud.cache.model.FlavorDTO;
import com.fit2cloud.cache.model.request.ListFlavorRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtCacheFlavorMapper {

    List<FlavorDTO> listFlavors(@Param("param") ListFlavorRequest request);
}