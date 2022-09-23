package com.mem.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@TableName("words")
@ApiModel(value="单词实体类",description="包含每条单词的数")
public class Word {
    private int id;
    private String uid;
    @ApiModelProperty(value = "唯一id",required = false)
    private String wid;
    @ApiModelProperty(value = "单词",required = false,example = "implicit")
    private String value;
    @ApiModelProperty(value = "时间",required = false)
    private String time;
    @ApiModelProperty(value = "是否标记",required = false,example = "1")
    private Integer marked;
    private int pointer;
    private int year;
    private int month;
    private int day;
    @TableField("custom_translation")
    private String customTranslation;

    public Word(String uid, String wid, String value, String time, int year, int month, int day,String customTranslation) {
        this.uid = uid;
        this.wid = wid;
        this.value = value;
        this.time = time;

        this.year = year;
        this.month = month;
        this.day = day;
        this.customTranslation=customTranslation;
    }
}
