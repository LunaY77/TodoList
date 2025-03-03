package com.iflove.todolist.service;

import com.iflove.todolist.common.domain.vo.response.RestBean;
import com.iflove.todolist.domain.vo.request.task.CreateTaskReq;
import com.iflove.todolist.domain.vo.request.task.ModifyTaskReq;
import com.iflove.todolist.domain.vo.response.task.TaskInfoResp;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
* @author cangjingyue
* @description 针对表【task(Todolist 任务表)】的数据库操作Service
* @createDate 2025-02-05 08:57:46
*/
public interface TaskService {

    /**
     * 创建任务
     * @param req 创建任务请求
     * @param uid 用户 id
     */
    void create(CreateTaskReq req, Long uid);

    /**
     * 删除任务
     * @param id 任务 id
     * @param uid 用户 id
     */
    void delete(@NotNull Long id, Long uid);

    /**
     * 修改任务
     * @param req 修改任务请求
     * @param uid 用户 id
     */
    void modify(ModifyTaskReq req, Long uid);

    /**
     * 获取全部任务
     */
    List<TaskInfoResp> queryAll(Long uid);

    /**
     * 根据任务的截止日期获取任务列表
     * @param dueDate 截止日期
     */
    List<TaskInfoResp> getTasksByDueDate(String dueDate, Long uid);
}
