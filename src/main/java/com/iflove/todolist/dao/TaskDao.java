package com.iflove.todolist.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflove.todolist.domain.dto.TaskInfoDto;
import com.iflove.todolist.domain.entity.Task;
import com.iflove.todolist.domain.vo.response.task.TaskInfoResp;
import com.iflove.todolist.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */
@Service
public class TaskDao extends ServiceImpl<TaskMapper, Task> {

    /**
     * 创建任务
     * @param dto 任务插入
     */
    public void create(TaskInfoDto dto) {
        baseMapper.create(dto);
    }

    /**
     * 查询任务
     * @param id 任务 id
     * @param uid 用户 id
     */
    public Task getByIdAndUid(Long id, Long uid) {
        return baseMapper.getByIdAndUid(id, uid);
    }

    /**
     * 删除任务
     * @param id 任务 id
     * @param uid 用户 id
     */
    public void delete(Long id, Long uid) {
        lambdaUpdate()
                .eq(Task::getId, id)
                .eq(Task::getUserId, uid)
                .remove();
    }

    /**
     * 修改任务
     * @param dto
     */
    public void modify(TaskInfoDto dto) {
        baseMapper.modify(dto);
    }

    /**
     * 查询某个用户的全部任务信息
     * @param uid 用户 id
     * @return 全部任务信息
     */
    public List<TaskInfoResp> queryAll(Long uid) {
        return this.baseMapper.queryAll(uid);
    }

    /**
     * 根据任务的截止日期获取任务列表
     * @param dueDate 截止日期
     */
    public List<TaskInfoResp> getTasksByDueDate(String dueDate, Long uid) {
        return this.baseMapper.getTasksByDueDate(dueDate, uid);
    }
}
