package com.wang.vo;

import com.wang.entity.HealthClock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 继承NocvData 所有的属性与方法，再额外添加页码和数量
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HealthClockVo extends HealthClock {
    private Integer page;
    private Integer limit;
}