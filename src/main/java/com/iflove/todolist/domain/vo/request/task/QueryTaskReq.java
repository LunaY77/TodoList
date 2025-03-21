package com.iflove.todolist.domain.vo.request.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote 任务查询请求
 */

@Data
@Schema(description = "任务查询请求")
public class QueryTaskReq {

    @Schema(description = "任务 id")
    @Nullable
    private Long id;

    @Schema(description = "任务标题")
    @Nullable
    private String title;

    @Schema(description = "截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Nullable
    private Date dueDate;

    @Schema(description = "分类名")
    @Length(min = 1, max = 10, message = "分类名称长度应该在 1-10之间")
    @Nullable
    private String categoryName;

    @Schema(description = "标签名列表")
    @Nullable
    private List<@Length(min = 1, max = 10, message = "标签名称长度应该在 1-10之间") String> tagNameList;

    @Schema(description = "任务星标 0: 无星标, 1: 有星标")
    @Nullable
    private Integer star;

    @Schema(description = "任务状态 0: 未完成, 1: 已完成")
    @Nullable
    private Integer status;
}
