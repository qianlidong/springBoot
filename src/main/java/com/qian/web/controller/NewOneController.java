package com.qian.web.controller;

import com.qian.common.AppContext;
import com.qian.domain.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qld on 2017/9/5.
 */
@Controller
@EnableAutoConfiguration
public class NewOneController {

    Logger logger= LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/newOne")
    @ResponseBody
    public  String newOne(HttpServletRequest request)  {

        logger.error("到了newone这里了");

        String str= AppContext.sLocal.get();
        AppContext.sLocal.set("newOne is this ......");
        logger.error(AppContext.sLocal.get());
        return  str;

    }


    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

}
