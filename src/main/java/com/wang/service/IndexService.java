package com.wang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.entity.LineTrend;
import com.wang.entity.NocvData;

import java.util.List;

public interface IndexService extends IService<NocvData> {
    List<LineTrend> findServenData();
}
