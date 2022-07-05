package com.wang.controller;

import com.wang.entity.LineTrend;
import com.wang.entity.NocvData;
import com.wang.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    //indexService注入进来
    //indexService 若标红，说明IndexService没有标注@service 交给spring去管理
    @Autowired
    private IndexService indexService;

    @RequestMapping("/query")
    @ResponseBody
    //返回成一个json 格式
    public List<NocvData> queryData(){
        List<NocvData> list = indexService.list();
        return list;
    }

    /**
     * 饼状图
     */
    // 跳转pie 界面
    @RequestMapping("/toPie")
    public String toPie(){
        return "pie";
    }

    /**
     * 分组  聚合   gyoup分类
     * SQL: select count(*) from goods gyoup gy type;
     */
    //数据查询
    @RequestMapping("/queryPie")
    @ResponseBody
    public List<NocvData> queryPieData(){
        List<NocvData> list = indexService.list();
        return list;
    }
    /**
     * 柱状图图
     */
    // 跳转 界面
    @RequestMapping("/toBar")
    public String toBar(){
        return "bar";
    }

    @RequestMapping("/queryBar")
    @ResponseBody
    public Map<String,List<Object>> queryBarData(){
        // 1. 所有城市数据：数值
        List<NocvData> list = indexService.list();

        // 2. 到所有的城市数据
        List<String> cityList = new ArrayList<>();
        for (NocvData data : list) {
            cityList.add(data.getName());
        }

        // 3. 所有疫情的数值数据
        List<Integer> dataList = new ArrayList<>();
        for (NocvData data : list) {
            dataList.add(data.getValue());
        }

        // 4. 创建Map
        Map map=new HashMap();
        map.put("cityList", cityList);
        map.put("dataList", dataList);
        return map;
    }

    /**
     * 折线图页面
     * SELECT * from qushishuju order by create_time limit 7;
     */
    @RequestMapping("/toLine")
    public String toLine(){
        return "line";
    }
//    携带数据传送到前端
    @RequestMapping("/queryLine")
    @ResponseBody
    public Map<String,List<Object>> queryLineData(){
        // 1.查询近七天所有的数据
        List<LineTrend> list7Day=indexService.findServenData();

        // 2.所有的确诊人数
        List<Integer> confirmList=new ArrayList<>();
        // 3.所有的隔离人数
        List<Integer> isolationList=new ArrayList<>();
        // 4.所有的治愈人数
        List<Integer> cureList=new ArrayList<>();
        // 5.所有的死亡人数
        List<Integer> deadList=new ArrayList<>();
        // 6.所有的疑似人数
        List<Integer> similarList=new ArrayList<>();
        for (LineTrend data: list7Day) {
            confirmList.add(data.getConfirm());
            isolationList.add(data.getIsolation());
            cureList.add(data.getCure());
            deadList.add(data.getDead());
            similarList.add(data.getSimilar());
        }

        // 7.返回数据的给前端
        Map map=new HashMap<>();
        map.put("confirmList",confirmList);
        map.put("isolationList",isolationList);
        map.put("cureList",cureList);
        map.put("deadList",deadList);
        map.put("similarList",similarList);
        return map;
    }


}