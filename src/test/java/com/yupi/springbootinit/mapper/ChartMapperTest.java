package com.yupi.springbootinit.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChartMapperTest {

    @Resource
    private ChartMapper chartMapper;

    @Test
    void queryChartData() {
        String chatId = "1714562524059226114";
        String querySql = String.format("Select * from chart_%s", chatId);
        List<Map<String, Object>> resultData =chartMapper.queryChartData(querySql);
        System.out.println(resultData);
    }
}