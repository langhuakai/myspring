package com.wei.myspring.demo.service.impl;

import com.wei.myspring.demo.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String get(String name) {
        return name;
    }
}
