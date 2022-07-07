package com.wang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.entity.HealthClock;
import com.wang.entity.NocvData;
import com.wang.service.HealthClockService;
import com.wang.vo.DataView;
import com.wang.vo.HealthClockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthClockController {
    //继承了mybatisplus的增删改查
    @Autowired
    private HealthClockService healthClockService;

    @RequestMapping("/toHealthClock")
    public String toHealthClock(){
        return "admin/healthclock";
    }

    /**
     * 查询所有打卡记录
     * @param healthClockVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/listHealthClock")
    //实体接收 HealthClockVo 需要创建
    public DataView listHealthClock(HealthClockVo healthClockVo){
        //查询左右带有模糊查询条 带有分页
        // 1.创建分页对象 当前页还有 每页限制大小
        IPage<HealthClock> page=new Page<>(healthClockVo.getPage(), healthClockVo.getLimit());
        // 2.创建MybatisPlus的模糊查询条件 getUsername()!=null 用户名不为空
        QueryWrapper<HealthClock> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(healthClockVo.getUsername()!=null,"username",healthClockVo.getUsername());
        queryWrapper.eq(healthClockVo.getPhone()!=null,"phone",healthClockVo.getPhone());
        // 4.查询数据库
        healthClockService.page(page,queryWrapper);
        return  new DataView(page.getTotal(),page.getRecords());
    }

    /**
     * addHealthClock 添加健康打卡数据
     */
    @RequestMapping("/addHealthClock")
    @ResponseBody
    public DataView addHealthClock(HealthClock healthClock){
        boolean b=healthClockService.saveOrUpdate(healthClock);
        DataView dataView=new DataView();
        if(b){
            dataView.setCode(200);
            dataView.setMsg("添加成功！");
        }
        dataView.setCode(100);
        dataView.setMsg("添加失败！");
        return dataView;
    }

    /**
     * 删除操作
     * deleteHealthClockById
     */
    @ResponseBody
    @RequestMapping("/deleteHealthClockById")
    public DataView deleteHealthClockById(Integer id){
        healthClockService.removeById(id);
        //赋值返回
        DataView dataView=new DataView();
        dataView.setCode(200);
        dataView.setMsg("删除数据成功!");
        return dataView;

    }
}