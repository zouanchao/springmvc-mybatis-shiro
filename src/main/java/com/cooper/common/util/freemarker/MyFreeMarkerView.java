package com.cooper.common.util.freemarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Copyright © 2016  All rights reserved.
 *
 * @Title: MyFreeMarkerView
 * @Prject: springmvc-mybatis-demo
 * @Package: com.cooper.common.util.freemarker
 * @Description: TODO
 * @author: JackCooperZ
 * @date: 2017/1/15 0015 下午 7:20
 * @version: V1.0
 */
public class MyFreeMarkerView extends FreeMarkerView {

    private  static Logger logger = LoggerFactory.getLogger(MyFreeMarkerView.class);

    private static final String CONTEXT_PATH = "base";

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        model.put(CONTEXT_PATH, request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
        logger.debug("base:"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
        super.exposeHelpers(model, request);
    }
}
