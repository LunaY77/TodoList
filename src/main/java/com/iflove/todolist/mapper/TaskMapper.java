package com.iflove.todolist.mapper;

import com.iflove.todolist.domain.dto.TaskInfoDto;
import com.iflove.todolist.domain.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflove.todolist.domain.vo.response.task.TaskInfoResp;

import java.util.List;

/**
* @author cangjingyue
* @description 针对表【task(Todolist 任务表)】的数据库操作Mapper
* @createDate 2025-02-05 08:57:46
* @Entity com.iflove.todolist.domain.entity.Task
*/
public interface TaskMapper extends BaseMapper<Task> {

    /**
     * 创建
     * @param dto 任务插入
     */
    void create(TaskInfoDto dto);

    /**
     * 查询任务
     * @param id 任务 id
     * @param uid 用户 id
     */
    Task getByIdAndUid(Long id, Long uid);

    /**
     * 修改任务信息
     * @param dto 任务信息
     */
    void modify(TaskInfoDto dto);

    /**
     * 查询某个用户的全部任务信息
     * @param uid 用户 id
     * @return 全部任务信息
     */
    List<TaskInfoResp> queryAll(Long uid);
}




