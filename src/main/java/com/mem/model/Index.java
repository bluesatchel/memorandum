package com.mem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Index {

    private int id;

    private String sentence;

    private String author;

    private String pic;
}
