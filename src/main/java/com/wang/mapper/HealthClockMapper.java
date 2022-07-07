package com.wang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.entity.HealthClock;
import org.apache.ibatis.annotations.Mapper;

/**
 * 继承   mybatisplus 框架 extends BaseMapper
 * 实体类  HealthClock
 */
@Mapper
public interface HealthClockMapper extends BaseMapper<HealthClock> {
}
