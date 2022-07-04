package com.wang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.entity.LineTrend;
import com.wang.entity.NocvData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IndexMapper extends BaseMapper <NocvData>{

    /**
     * 接口：只有方法定义，不能有实现
     * 1.实现类，写自己的业务逻辑
     * 2.XML MybatisPlus  一种实现类
     * 3.@Select
     * @return
     */
    @Select("select * from line_trend order by create_time limit 7")
    List<LineTrend> findSevenData();
}