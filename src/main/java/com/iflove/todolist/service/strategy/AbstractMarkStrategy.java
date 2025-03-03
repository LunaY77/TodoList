package com.iflove.todolist.service.strategy;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.iflove.todolist.common.domain.enums.ActionTypeEnum;
import com.iflove.todolist.common.domain.enums.MarkTypeEnum;
import com.iflove.todolist.common.domain.enums.StatusEnum;
import com.iflove.todolist.dao.TaskDao;
import com.iflove.todolist.domain.entity.Task;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */
public abstract class AbstractMarkStrategy {

    private TaskDao taskDao;

    @PostConstruct
    private void init() {
        MarkFactory.register(getTypeEnum().getType(), this);
        if (Objects.isNull(taskDao)) {
            taskDao = SpringUtil.getBean(TaskDao.class);
        }
    }

    protected abstract MarkTypeEnum getTypeEnum();

    @Transactional
    public void mark(Long uid, Long taskId) {
        doMark(uid, taskId);
    }

    @Transactional
    public void unMark(Long uid, Long taskId) {
        doUnMark(uid, taskId);
    }

    protected void doMark(Long uid, Long taskId) {
        exec(uid, taskId, ActionTypeEnum.MARK);
    }

    protected void doUnMark(Long uid, Long taskId) {
        exec(uid, taskId, ActionTypeEnum.UN_MARK);
    }

    protected void exec(Long uid, Long taskId, ActionTypeEnum actType) {
        MarkTypeEnum markType = this.getTypeEnum();
        // 跳过重复操作
        // 1. 任务未星标 + 取消标记
        // 2. 任务星标 + 标记操作
        // 3. 任务未完成 + 取消操作
        // 4. 任务已完成 + 标记操作
        Task exist = taskDao.exist(uid, taskId, markType);
        if (Objects.equals(exist.getStar(), StatusEnum.ZERO.getStatus()) && Objects.equals(actType, ActionTypeEnum.UN_MARK)
            || Objects.equals(exist.getStar(), StatusEnum.ONE.getStatus()) && Objects.equals(actType, ActionTypeEnum.MARK)
            || Objects.equals(exist.getStatus(), StatusEnum.ZERO.getStatus()) && Objects.equals(actType, ActionTypeEnum.UN_MARK)
            || Objects.equals(exist.getStatus(), StatusEnum.ONE.getStatus()) && Objects.equals(actType, ActionTypeEnum.MARK)) {
            return;
        }
        taskDao.mark(uid, taskId, markType, actType);
    }
}
