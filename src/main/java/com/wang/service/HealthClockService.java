package com.wang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.entity.HealthClock;

/**
 *把通用的接口提取到公共。其实按照MP的这种思想，可以自己也实现一些通用的Controller。
 *MybatisPlus 的通用的Service层
 */
public interface HealthClockService extends IService<HealthClock> {
}
