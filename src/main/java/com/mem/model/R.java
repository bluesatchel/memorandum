package com.mem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {

    public static int SUCCESS=200;
    public static int FAIL=500;

    private int status;
    private String message;
    private Object data;

    public R(int status, String message) {
        this.status = status;
        this.message = message;
    }
}