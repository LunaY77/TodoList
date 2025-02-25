package com.iflove.todolist.controller;

import com.iflove.todolist.common.domain.vo.response.RestBean;
import com.iflove.todolist.common.utils.RequestHolder;
import com.iflove.todolist.domain.vo.request.task.CreateTaskReq;
import com.iflove.todolist.domain.vo.request.task.DeleteTaskReq;
import com.iflove.todolist.domain.vo.request.task.ModifyTaskReq;
import com.iflove.todolist.domain.vo.response.task.TaskInfoResp;
import com.iflove.todolist.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */

@RestController
@RequestMapping("/api/task")
@Validated
@Tag(name = "任务模块")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    // TODO 查询 task(日期, 标签，分类)

    /**
     * 创建任务
     * @param req 创建任务请求
     * @return {@link RestBean}
     */
    @PostMapping("create")
    @Operation(summary = "创建任务",
            description = "创建任务",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> create(@RequestBody @Valid CreateTaskReq req) {
        taskService.create(req, RequestHolder.get().getUid());
        return RestBean.success();
    }

    /**
     * 删除任务
     * @param req 删除任务请求
     * @return {@link RestBean}
     */
    @DeleteMapping("delete")
    @Operation(summary = "删除任务",
            description = "删除任务",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> delete(@RequestBody @Valid DeleteTaskReq req) {
        taskService.delete(req.getId(), RequestHolder.get().getUid());
        return RestBean.success();
    }

    /**
     * 修改任务
     * @param req 修改任务请求
     * @return {@link RestBean}
     */
    @PutMapping("modify")
    @Operation(summary = "修改任务",
            description = "修改任务",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<Void> modify(@RequestBody @Valid ModifyTaskReq req) {
        taskService.modify(req, RequestHolder.get().getUid());
        return RestBean.success();
    }

    /**
     * 获取全部任务
     * @return {@link RestBean}
     */
    @GetMapping("queryAll")
    @Operation(summary = "获取全部任务",
            description = "获取全部任务",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<List<TaskInfoResp>> queryAll() {
        return RestBean.success(taskService.queryAll(RequestHolder.get().getUid()));
    }

    /**
     * 根据任务的截止日期获取任务列表
     * @param dueDate 截止日期
     * @return 任务列表
     */
    @GetMapping("/byDueDate")
    @Operation(summary = "根据任务的截止日期获取任务列表",
            description = "根据任务的截止日期获取任务列表",
            security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
    })
    public RestBean<List<TaskInfoResp>> getTasksByDueDate(@RequestParam("dueDate") String dueDate) {
        return RestBean.success(taskService.getTasksByDueDate(dueDate, RequestHolder.get().getUid()));
    }
}