package com.wang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.entity.HealthClock;
import com.wang.mapper.HealthClockMapper;
import com.wang.service.HealthClockService;
import org.springframework.stereotype.Service;

/**
 *继承  ServiceImpl类的方法，同时 实现 HealthClockService 接口
 */
@Service
public class HealthClockServiceImpl extends ServiceImpl<HealthClockMapper, HealthClock> implements HealthClockService {
}