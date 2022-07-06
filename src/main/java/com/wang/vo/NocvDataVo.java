package com.wang.vo;

import com.wang.entity.NocvData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 继承NocvData 所有的属性与方法，再额外添加页码和数量
 */
public class NocvDataVo extends NocvData {
    private Integer page;
    private Integer limit;
}