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
public enum StatusEnum {
    ZERO(0, "未完成 0"),
    ONE(1, "已完成 1"),
    ;

    private final Integer status;
    private final String desc;

    private static final Map<Integer, StatusEnum> cache;

    static {
        cache = Arrays.stream(StatusEnum.values()).collect(Collectors.toMap(StatusEnum::getStatus, Function.identity()));
    }

    public static StatusEnum of(Integer type) {
        return cache.get(type);
    }
}
