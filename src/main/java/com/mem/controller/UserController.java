package com.mem.controller;

import com.mem.mapper.UserMapper;
import com.mem.model.R;
import com.mem.model.User;
import com.mem.utils.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.dreamlu.mica.xss.core.XssCleanIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserMapper userMapper;
    @ApiOperation(value = "登录",notes = "用户登录")
    @PostMapping("/login")
    public R login(@RequestBody User user){

        R r = new R(R.FAIL, "登录失败");
        User loginUser=userMapper.login(user);

        if(!Objects.isNull(loginUser)){
            loginUser.setPassword("");
            r.setData(loginUser);
            r.setStatus(R.SUCCESS);
            r.setMessage("登录成功");

        }


        //TODO 用户校验入库

        return r;
    }

    @ApiOperation(value = "注册",notes = "用户注册")
    @PostMapping("/register")
    public R register(@RequestBody User user){
        R r = new R(R.FAIL, "注册失败");

        user.setUid(UUIDUtil.getUUID32());
        boolean flag=userMapper.register(user);

        if(flag){

            r.setMessage("注册成功");
            r.setStatus(R.SUCCESS);
        }

        //TODO 用户信息入库

        return r;
    }

    @ApiOperation(value = "退出登录",notes = "退出登录")
    @PostMapping("/logout")
    public R logout(){
        R r = new R(R.FAIL, "退出成功");

        //TODO 用户校验入库

        return r;
    }








}
