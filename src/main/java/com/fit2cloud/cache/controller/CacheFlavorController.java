package com.fit2cloud.cache.controller;

import com.fit2cloud.cache.common.constants.PermissionConstants;
import com.fit2cloud.cache.service.FlavorService;
import com.fit2cloud.cache.model.FlavorDTO;
import com.fit2cloud.cache.model.request.ListFlavorRequest;
import com.fit2cloud.commons.utils.PageUtils;
import com.fit2cloud.commons.utils.Pager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("flavor")
public class CacheFlavorController {

    @Resource
    private FlavorService flavorService;

    @PostMapping("list/{goPage}/{pageSize}")
    @ApiOperation("查看flavor")
    @RequiresPermissions(PermissionConstants.FLAVOR_READ)
    public Pager<List<FlavorDTO>> selectCloudServers(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody ListFlavorRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, flavorService.listFlavors(request));
    }

}
