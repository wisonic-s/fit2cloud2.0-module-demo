package com.fit2cloud.cache.model;

import com.fit2cloud.cache.domain.CacheFlavor;
import lombok.Data;

@Data
public class FlavorDTO extends CacheFlavor {
    private String workspaceName;
}
