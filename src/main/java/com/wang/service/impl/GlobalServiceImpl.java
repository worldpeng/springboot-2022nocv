package com.wang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.entity.NocvGlobalData;
import com.wang.mapper.GlobalDataMapper;
import com.wang.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalServiceImpl extends ServiceImpl<GlobalDataMapper, NocvGlobalData> implements GlobalService {
    @Autowired
    private GlobalDataMapper globalDataMapper;


}