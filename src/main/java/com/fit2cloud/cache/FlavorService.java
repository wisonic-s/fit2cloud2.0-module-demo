package com.fit2cloud.cache;

import com.alibaba.fastjson.JSONObject;
import com.fit2cloud.cache.dao.CacheCloudAccountMapper;
import com.fit2cloud.cache.dao.CacheFlavorMapper;
import com.fit2cloud.cache.dao.ext.ExtCacheFlavorMapper;
import com.fit2cloud.cache.domain.CacheCloudAccount;
import com.fit2cloud.cache.domain.CacheFlavor;
import com.fit2cloud.cache.domain.CacheFlavorExample;
import com.fit2cloud.cache.model.FlavorDTO;
import com.fit2cloud.cache.model.request.ListFlavorRequest;
import com.fit2cloud.commons.utils.UUIDUtil;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.dcs.v2.DcsClient;
import com.huaweicloud.sdk.dcs.v2.model.FlavorsItems;
import com.huaweicloud.sdk.dcs.v2.model.ListFlavorsRequest;
import com.huaweicloud.sdk.dcs.v2.model.ListFlavorsResponse;
import com.huaweicloud.sdk.dcs.v2.region.DcsRegion;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlavorService {
    @Resource
    private CacheFlavorMapper cacheFlavorMapper;
    @Resource
    private CacheCloudAccountMapper cacheCloudAccountMapper;

    @Resource
    private ExtCacheFlavorMapper extCacheFlavorMapper;

    public void syncFlavors() {
        List<CacheCloudAccount> accounts = cacheCloudAccountMapper.selectByExample(null);
        if (CollectionUtils.isNotEmpty(accounts)) {
            accounts.forEach(account -> {
                String credential = account.getCredential();
                JSONObject credentialObj = JSONObject.parseObject(credential);
                String accessKey = credentialObj.getString("accessKey");
                String secretKey = credentialObj.getString("secretKey");
                DcsClient client = getClient(accessKey, secretKey);

                ListFlavorsResponse listFlavorsResponse = client.listFlavors(new ListFlavorsRequest());
                List<FlavorsItems> flavors = listFlavorsResponse.getFlavors();
                if (CollectionUtils.isNotEmpty(flavors)) {
                    flavors.forEach(item -> {
                        CacheFlavor cacheFlavor = new CacheFlavor();
                        cacheFlavor.setId(UUIDUtil.newUUID());
                        cacheFlavor.setEngine(item.getEngine());
                        cacheFlavor.setInstaneType(item.getSpecCode());
                        cacheFlavor.setEngineVersion(item.getEngineVersion());
                        cacheFlavorMapper.insert(cacheFlavor);
                    });
                }
            });
        }
    }

    public DcsClient getClient(String accessKey, String secretKey) {
        BasicCredentials basicCredentials = new BasicCredentials()
                .withAk(accessKey)
                .withSk(secretKey);
        return DcsClient.newBuilder().withCredential(basicCredentials)
                .withRegion(DcsRegion.CN_NORTH_4).build();
    }

    public List<FlavorDTO> listFlavors(ListFlavorRequest request) {
        return extCacheFlavorMapper.listFlavors(request);
    }
}
