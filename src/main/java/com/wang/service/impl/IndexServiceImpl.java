package com.wang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.mapper.IndexMapper;
import com.wang.entity.LineTrend;
import com.wang.entity.NocvData;
import com.wang.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl extends ServiceImpl<IndexMapper, NocvData>implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<LineTrend> findServenData() {
        List<LineTrend> list=indexMapper.findSevenData();
        return list;
    }
}