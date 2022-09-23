package com.mem.controller;

import com.mem.mapper.IndexMapper;
import com.mem.model.Index;
import com.mem.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.dreamlu.mica.xss.core.XssCleanIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@Api(tags = "主页展示信息")
@RestController

public class IndexController {
    @Autowired
    IndexMapper indexMapper;
    @ApiOperation(value = "获取图片和名言", notes = "随机获取名言和图片地址,用于主页展示")
    @PostMapping("/getOne")
    public R login() {
        R r = new R(R.FAIL, "获取");

        Index one = indexMapper.getOne();
        r.setMessage("获取成功");
        r.setData(one);
        r.setStatus(R.SUCCESS);


        return r;
    }

}