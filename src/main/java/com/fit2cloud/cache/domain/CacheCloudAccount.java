package com.fit2cloud.cache.domain;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CacheCloudAccount implements Serializable {
    @ApiModelProperty("云账号主键")
    private String id;

    @ApiModelProperty("账号名称")
    private String name;

    @ApiModelProperty("插件名称")
    private String pluginName;

    @ApiModelProperty("云账号凭证")
    private String credential;

    @ApiModelProperty("账号状态")
    private String status;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("更新时间")
    private Long updateTime;

    @ApiModelProperty("同步状态")
    private String syncStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName == null ? null : pluginName.trim();
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential == null ? null : credential.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus == null ? null : syncStatus.trim();
    }
}