package com.fit2cloud.cache.domain;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CacheFlavor implements Serializable {
    @ApiModelProperty("")
    private String id;

    @ApiModelProperty("")
    private String workspace;

    @ApiModelProperty("")
    private String instanceType;

    @ApiModelProperty("")
    private String engine;

    @ApiModelProperty("")
    private String engineVersion;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace == null ? null : workspace.trim();
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType == null ? null : instanceType.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion == null ? null : engineVersion.trim();
    }
}