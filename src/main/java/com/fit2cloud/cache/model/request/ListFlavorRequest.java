package com.fit2cloud.cache.model.request;

import lombok.Data;

@Data
public class ListFlavorRequest extends BaseRequest{
    private String engineVersion;
    private String engine;
}
