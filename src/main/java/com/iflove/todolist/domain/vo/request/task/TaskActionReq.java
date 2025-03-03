package com.iflove.todolist.domain.vo.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "任务星标/完成请求")
public class TaskActionReq {

    /**
     * 任务id
     */
    @Schema(description = "任务id")
    @NotNull
    private Long taskId;

    /**
     * 标记类型 1 星标 / 2 完成
     * @see com.iflove.todolist.common.domain.enums.MarkTypeEnum
     */
    @Schema(description = "标记类型 1 星标 / 2 完成")
    @NotNull
    @Min(1)
    @Max(2)
    private Integer markType;

    /**
     * 动作类型 1 确认 / 2 取消
     * @see com.iflove.todolist.common.domain.enums.ActionTypeEnum
     */
    @Schema(description = "动作类型 1 确认 / 2 取消")
    @Min(1)
    @Max(2)
    private Integer actionType;
}
