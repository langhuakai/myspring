package com.wei.myspring.mvcframework.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class WeiDispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 跟web.xml中param-name的值保持一致
    private static final String LOCATION = "contextConfigLocation";
    // 保存所有的配置信息
    private Properties  properties = new Properties();
    // 保存所有被扫描到的相关的类名
    private List<String> classNames = new ArrayList<>();
    // 核心IOC容器，保存所有初始化的bean
    private Map<String, Object> ioc = new HashMap<>();
    // 保存所有的URL和方法的映射关系
    private Map<String, Method> handlerMapping = new HashMap<>();

    public WeiDispatcherServlet() {
        super();
    }

    /**
     * 初始化，加载配置文件
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    private void doLoadConfig(String location) {
        InputStream fis = null;
        fis = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fis) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader()
                .getResource("/" + packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if(file.isDirectory()) {
                doScanner(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replace(".class", "").trim());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * 执行业务逻辑
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
