package com.wei.myspring.demo.mvc.action;

import com.wei.myspring.demo.service.DemoService;
import com.wei.myspring.mvcframework.annotation.WeiAutowired;
import com.wei.myspring.mvcframework.annotation.WeiController;
import com.wei.myspring.mvcframework.annotation.WeiRequestMapping;
import com.wei.myspring.mvcframework.annotation.WeiRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WeiController
@WeiRequestMapping("/demo")
public class DemoAction {

    @WeiAutowired
    private DemoService demoService;

    @WeiRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @WeiRequestParam("name") String name) {
        String result = demoService.get(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @WeiRequestMapping("add")
    public void add(HttpServletRequest request, HttpServletResponse response,
                   @WeiRequestParam("a") Integer a, @WeiRequestParam("b") Integer b) {
        try {
            response.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response,
                      @WeiRequestParam("id") Integer id) {

    }
}
