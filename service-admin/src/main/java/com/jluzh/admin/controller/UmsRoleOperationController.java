package com.jluzh.admin.controller;


import cn.hutool.core.collection.CollUtil;
import com.jluzh.admin.dto.RoleOperationDto;
import com.jluzh.admin.model.UmsRoleOperation;
import com.jluzh.admin.service.service.UmsRoleOperationService;
import com.jluzh.api.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author banana
 * @since 2022-09-17
 */
@RestController
@Api(tags = "UmsRoleOperationController", description = "角色操作权限管理")
@RequestMapping("/admin/umsRoleOperation")
public class UmsRoleOperationController {
    @Resource(name = "umsRoleOperationServiceImpl")
    private UmsRoleOperationService operationService;
    @GetMapping("/initRoleOperation/{adminId}")
    public CommonResult initRoleOperationsByAdminId(@PathVariable Long adminId) {
        List<RoleOperationDto> result = operationService.init(adminId);
        if (CollUtil.isNotEmpty(result)) {
            return CommonResult.success(result);
        }else {
            return CommonResult.failed();
        }
    }
}

