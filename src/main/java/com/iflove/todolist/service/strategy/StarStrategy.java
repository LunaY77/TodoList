package com.iflove.todolist.service.strategy;

import com.iflove.todolist.common.domain.enums.MarkTypeEnum;
import com.iflove.todolist.dao.TaskDao;
import org.springframework.stereotype.Component;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */
@Component
public class StarStrategy extends AbstractMarkStrategy {

    @Override
    protected MarkTypeEnum getTypeEnum() {
        return MarkTypeEnum.STAR;
    }
}
