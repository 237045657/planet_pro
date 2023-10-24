package com.yupi.springbootinit.mapper;

import com.yupi.springbootinit.model.entity.Chart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author hsw237045657
* @description 针对表【chart(图表信息表)】的数据库操作Mapper
* @createDate 2023-09-19 21:40:06
* @Entity com.yupi.springbootinit.model.entity.Chart
*/
public interface ChartMapper extends BaseMapper<Chart> {
    /**方法的返回类型是List<Map<String, object>>,
     * 表示返回的是一个由多个map 组成的集合,每个map代表了一行查询结果，
     * 并将其封装成了一组键值对形式的对象。其中 , string类型代表了键的类型为字符串，
     * object类型代表了值的类型为任意对象,使得这个方法可以适应不同类型的数据查询。
     */

    List<Map<String, Object>> queryChartData(String querySql);

}




