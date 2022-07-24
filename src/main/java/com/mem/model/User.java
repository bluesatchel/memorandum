package com.mem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    @ApiModelProperty("uuid")
    private String uid;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("用户名")
    private String username;
    private String password;
}