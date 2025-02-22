package com.iflove.todolist.domain.vo.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 苍镜月
 * @version 1.0
 * @implNote 头像上传请求
 */

@Data
@Schema(description = "头像上传请求")
public class UploadAvatarReq {
    @Schema(description = "头像 url")
    @NotBlank
    private String url;
}
