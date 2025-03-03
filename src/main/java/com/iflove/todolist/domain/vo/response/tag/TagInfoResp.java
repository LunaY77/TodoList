package com.iflove.todolist.domain.vo.response.tag;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote
 */

@Schema(description = "标签信息返回体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagInfoResp {

    @Schema(description = "标签 id")
    private Long id;

    @Schema(description = "标签名")
    private String name;
}
