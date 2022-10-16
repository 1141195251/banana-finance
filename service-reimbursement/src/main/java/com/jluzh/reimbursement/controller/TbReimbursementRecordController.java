package com.jluzh.reimbursement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.api.CommonPage;
import com.jluzh.api.CommonResult;
import com.jluzh.reimbursement.entity.TbReimbursementRecord;
import com.jluzh.reimbursement.service.TbReimbursementRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * (TbReimbursementRecord)表控制层
 *
 * @author
 * @since 2022-10-16 22:24:11
 */
@Api(tags = "(TbReimbursementRecord)")
@RestController
@RequestMapping("/rm/tbReimbursementRecord")
public class TbReimbursementRecordController {
    /**
     * 服务对象
     */
    @Resource
    private TbReimbursementRecordService tbReimbursementRecordService;

    /**
     * 分页查询所有数据
     *
     * @param page                  分页对象
     * @param tbReimbursementRecord 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<TbReimbursementRecord> page, TbReimbursementRecord tbReimbursementRecord) {
        return CommonResult.success(CommonPage.restPage(tbReimbursementRecordService.page(page, new QueryWrapper<>(tbReimbursementRecord))));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public CommonResult selectOne(@PathVariable Serializable id) {
        return CommonResult.success(this.tbReimbursementRecordService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementRecord 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody TbReimbursementRecord tbReimbursementRecord) {
        return CommonResult.success(this.tbReimbursementRecordService.save(tbReimbursementRecord));
    }

    /**
     * 修改数据
     *
     * @param tbReimbursementRecord 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody TbReimbursementRecord tbReimbursementRecord) {
        return CommonResult.success(this.tbReimbursementRecordService.updateById(tbReimbursementRecord));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return CommonResult.success(this.tbReimbursementRecordService.removeByIds(idList));
    }

    @ApiOperation(value = "下载数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response) throws IOException {
        tbReimbursementRecordService.writeExcel(response);
    }

    /**
     * 上传Excel文件信息存入数据库
     * @param file 文件流
     */
    @ApiOperation(value = "上传Excel")
    @PostMapping("/upload")
    public void readExcel(@RequestPart @RequestParam("file") MultipartFile file){
        tbReimbursementRecordService.readExcel(file);
    }
}

