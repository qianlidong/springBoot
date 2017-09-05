package com.qian.web.controller;

import com.qian.domain.CbCorpApply;
import com.qian.domain.MyException;
import com.qian.repository.CbrmbServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qld on 2017/7/19.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Value("value=${qian.mima}")
    private String mima;

    @Autowired
    private CbrmbServiceRepository cbrmbServiceRepository;

    @RequestMapping("/home")
    @ResponseBody
    public  String home() throws  MyException{
        Map map=new HashMap();
        logger.info("这个结果是"+map.get("zx"));
        logger.info("这个肯定得解决呀!");
        CbCorpApply cca=cbrmbServiceRepository.findByCustId("222222");
        try{
          String str=null;
          str.charAt(0);
        }catch (Exception e){
            throw new MyException("我抛出的异常-----------------------------------------",e);
        }
        CbCorpApply cca1=new CbCorpApply();
        cca.setApplyDate(new Date());
        //cca1.setCustId("200808");
        cca.setCorpName("gopaycawolaile");
        cca.setCorpUrl("www.123.com");
        cbrmbServiceRepository.save(cca);
        List<CbCorpApply> listAll=cbrmbServiceRepository.findAll();
        logger.info("个数是："+listAll.size());
        return "This is My First SpringBoot!"+mima+cca.getCorpName();
    }


}
