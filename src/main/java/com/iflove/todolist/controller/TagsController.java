package com.iflove.todolist.controller;

import com.iflove.todolist.common.domain.vo.response.RestBean;
import com.iflove.todolist.common.utils.RequestHolder;
import com.iflove.todolist.domain.vo.request.tags.TagsNameReq;
import com.iflove.todolist.domain.vo.response.category.CategoryInfoResp;
import com.iflove.todolist.domain.vo.response.tag.TagInfoResp;
import com.iflove.todolist.service.TagsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@RequestMapping("/api/tags")
@Validated
@Tag(name = "标签模块")
@RequiredArgsConstructor
public class TagsController {
    private final TagsService tagsService;

    // TODO 为任务添加标签，为任务删除标签, 为任务修改标签，修改标签信息, 查询标签(全部)

    /**
     * 创建用户的任务标签(用户独有), 可以一次创建多个
     * @param req 任务标签创建请求
     * @return {@link RestBean}
     */
    @PostMapping("create")
    @Operation(summary = "创建标签",
            description = "创建用户的任务标签(用户独有), 可以一次创建多个",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> create(@RequestBody @Valid TagsNameReq req) {
        tagsService.create(req.getTagNameList(), RequestHolder.get().getUid());
        return RestBean.success();
    }

    /**
     * 删除用户的任务标签(用户独有)，可以一次删除多个
     * @param req 任务标签删除请求
     * @return {@link RestBean}
     */
    @DeleteMapping("delete")
    @Operation(summary = "删除标签",
            description = "删除用户的任务标签(用户独有)，可以一次删除多个",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> delete(@RequestBody @Valid TagsNameReq req) {
        tagsService.delete(req.getTagNameList(), RequestHolder.get().getUid());
        return RestBean.success();
    }

    @GetMapping("batch")
    @Operation(summary = "批量获取",
            description = "批量获取当前用户所有标签",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<List<TagInfoResp>> batch() {
        List<TagInfoResp> lst = tagsService.batch();
        return RestBean.success(lst);
    }

//    @PutMapping("modify")
//    @Operation(summary = "修改标签",
//            description = "根据 标签id 修改用户的任务标签(用户独有)",
//            security = {@SecurityRequirement(name = "Authorization")})
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "success"),
//    })
//    public RestBean<Void> modify(@RequestBody @Valid TagModifyReq req) {
//
//    }
}
