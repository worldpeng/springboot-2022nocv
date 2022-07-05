package com.wang.controller;

import com.wang.entity.NocvData;
import com.wang.entity.NocvGlobalData;
import com.wang.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GlobalController {
    //服务 注入进来
    @Autowired
    private GlobalService globalService;
    //    跳转页面
    @RequestMapping("/toGlobal")
    public String toGlobal(){
        return "global";
    }

    @RequestMapping("/queryGlobal")
    @ResponseBody
    //返回成一个json 格式
    public List<NocvGlobalData> queryData(){
        //mybatis默认查询全部数据
        List<NocvGlobalData> list = globalService.list();
        return list;
    }
}