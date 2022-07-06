package com.wang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.entity.NocvData;
import com.wang.service.IndexService;
import com.wang.vo.DataView;
import com.wang.vo.NocvDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChinaDataAdminController {

    @Autowired
    private IndexService indexService;


    //跳转页面
    @RequestMapping("/toChinaManager")
    public  String toChinaManager(){
        return "admin/chinadatamanger";
    }

    /**
     * 模糊查询，带有分页
     * @return
     */
    @RequestMapping("/listDataByPage")
    @ResponseBody
    public DataView listDataByPage(NocvDataVo nocvDataVo){
        // 1.创建分页对象 当前页还有 每页限制大小
        IPage<NocvData> page=new Page<>(nocvDataVo.getPage(), nocvDataVo.getLimit());
        // 2.创建MybatisPlus的模糊查询条件
        QueryWrapper<NocvData> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(!(nocvDataVo.getName()==null),"name",nocvDataVo.getName());
        // 3.疫情数据确诊最多的排在上面
        queryWrapper.orderByDesc("value");
        // 4.查询数据库
        indexService.page(page,queryWrapper);
        // 5.返回数据格式封装  getTotal 一共有多少条数据; getRecords 所有的数据放进去
        DataView dataView=new DataView(page.getTotal(),page.getRecords());
        return dataView;
    }

    /**
     * 删除数据 根据id
     * @param id
     * @return
     */
    @RequestMapping("/china/deleteById")
    @ResponseBody
    public DataView deleteById(Integer id){
        //Sql 的语句
        indexService.removeById(id);
        //赋值返回
        DataView dataView=new DataView();
        dataView.setCode(200);
        dataView.setMsg("删除中国地图数据成功!");
        return dataView;
    }

    /**
     * 新增或者修改【ID】
     * id: nocvData 有id值就是修改，没有值就是新增
     * updata nocv_data set name="" where id =?
     * insert into
     * @param nocvData
     * @return
     */
    @RequestMapping("/china/addOrUpdateChina")
    @ResponseBody
    public DataView addChina(NocvData nocvData){
        //Sql 的语句
        boolean save = indexService.saveOrUpdate(nocvData);
        DataView dataView=new DataView();
        if(save){
            //赋值返回
            dataView.setCode(200);
            dataView.setMsg("新增中国地图数据成功!");
            return dataView;
        }
        dataView.setCode(100);
        dataView.setMsg("新增中国地图数据失败!");
        return dataView;
    }
}