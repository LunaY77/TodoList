package com.iflove.todolist.domain.vo.response.task;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */

@Data
@Schema(description = "任务信息")
public class TaskInfoResp {
    /**
     * 任务id
     */
    @Schema(description = "任务id")
    private Long id;

    /**
     * 用户id，关联用户表
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 任务标题
     */
    @Schema(description = "任务标题")
    private String title;

    /**
     * 任务描述
     */
    @Schema(description = "任务描述")
    private String description;

    /**
     * 任务状态 0: 未完成, 1: 已完成
     */
    @Schema(description = "任务状态 0: 未完成, 1: 已完成")
    private Integer status;

    /**
     * 任务星标 0: 无星标, 1: 有星标
     */
    @Schema(description = "任务星标 0: 无星标, 1: 有星标")
    private Integer star;

    /**
     * 任务截止日期
     */
    @Schema(description = "任务截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dueDate;

    /**
     * 任务创建时间
     */
    @Schema(description = "任务创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 任务分类
     */
    @Schema(description = "任务分类")
    private String category;

    /**
     * 任务标签列表
     */
    @Schema(description = "任务标签(String 类型，前端自行分割，例: \"tag1,tag2,tag3\")")
    private String tags;
}
