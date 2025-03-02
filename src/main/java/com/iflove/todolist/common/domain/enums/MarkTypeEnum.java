package com.iflove.todolist.common.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */
@AllArgsConstructor
@Getter
public enum MarkTypeEnum {
    STAR(1, "星标任务"),
    DONE(2, "完成任务"),
    ;

    private final Integer type;
    private final String desc;


    private static final Map<Integer, MarkTypeEnum> cache;

    static {
        cache = Arrays.stream(MarkTypeEnum.values()).collect(Collectors.toMap(MarkTypeEnum::getType, Function.identity()));
    }

    public static MarkTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
