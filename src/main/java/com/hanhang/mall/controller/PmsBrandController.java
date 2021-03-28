package com.hanhang.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanhang.mall.common.api.CommonResult;
import com.hanhang.mall.dao.PmsBrandMapper;
import com.hanhang.mall.entity.PmsBrand;
import com.hanhang.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 */
@Api(tags = "PmsBrandController")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.list());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        boolean saved = pmsBrandService.save(pmsBrand);
        if (saved){
            commonResult = CommonResult.success(pmsBrand);
        }else {
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        UpdateWrapper<PmsBrand> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        boolean updated = pmsBrandService.update(pmsBrandDto,updateWrapper);
        if (updated) {
            commonResult = CommonResult.success(pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        UpdateWrapper<PmsBrand> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        boolean removed = pmsBrandService.remove(updateWrapper);
        if (removed) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Page> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSie", defaultValue = "3") Integer pageSize) {
        Page<PmsBrand> page = new Page<>(pageNum,pageSize);
        pmsBrandService.page(page,null);
        return CommonResult.success(page);
    }

    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return CommonResult.success(pmsBrandService.getOne(queryWrapper));
    }
}
