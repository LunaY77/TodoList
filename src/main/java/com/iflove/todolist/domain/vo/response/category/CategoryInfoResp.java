package com.iflove.todolist.domain.vo.response.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */

@Schema(description = "分类信息返回体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInfoResp {

    @Schema(description = "分类 id")
    private Long id;

    @Schema(description = "分类名")
    private String name;
}
