package com.iflove.todolist.controller;

import com.iflove.todolist.common.domain.vo.response.RestBean;
import com.iflove.todolist.common.utils.RequestHolder;
import com.iflove.todolist.domain.vo.request.category.CategoryNameReq;
import com.iflove.todolist.domain.vo.response.category.CategoryInfoResp;
import com.iflove.todolist.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */

@RestController
@RequestMapping("/api/category")
@Validated
@Tag(name = "分类模块")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    // TODO 为任务添加分类，为任务删除分类, 为任务修改分类，修改分类信息, 查询分类

    /**
     * 创建用户的任务分类(用户独有), 可以一次创建多个
     *
     * @param req 分类名请求
     * @return {@link RestBean}
     */
    @PostMapping("create")
    @Operation(summary = "创建分类",
            description = "创建用户的任务分类(用户独有), 可以一次创建多个",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> create(@RequestBody @Valid CategoryNameReq req) {
        categoryService.create(req.getCategoryNameList(), RequestHolder.get().getUid());
        return RestBean.success();
    }


    /**
     * 删除用户的任务分类(用户独有)，可以一次删除多个
     *
     * @param req 任务分类删除请求
     * @return {@link RestBean}
     */
    @DeleteMapping("delete")
    @Operation(summary = "删除分类",
            description = "删除用户的任务分类(用户独有)，可以一次删除多个",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> delete(@RequestBody @Valid CategoryNameReq req) {
        categoryService.delete(req.getCategoryNameList(), RequestHolder.get().getUid());
        return RestBean.success();
    }

    // TODO 可能暴露一个根据名字查询 id 的接口，批量
    @GetMapping("batch")
    @Operation(summary = "批量获取",
            description = "批量获取当前用户所有分类",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<List<CategoryInfoResp>> batch() {
        List<CategoryInfoResp> lst = categoryService.batch();
        return RestBean.success(lst);
    }
}
