package com.mem.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private int year;
    private int month;
    private int day;
    @TableField("addnum")
    private int addnum;
    @TableField("reviewnum")
    private int reviewnum;
    private String uid;


}
