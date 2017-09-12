package com.qian.web.controller;

import com.qian.common.AppContext;
import com.qian.config.RedisConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by qld on 2017/8/25.
 */
@RestController
@EnableAutoConfiguration
public class RedisController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    private static JedisCluster jedisCluster=null;
    private static Set<HostAndPort> hostAndPorts=null;

    @Value("value=${qian.mima}")
    private String mima;

    @Autowired
    private RedisConfig redisConfig;

    private ThreadLocal<String> threadLocal=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "我肯定不说这个值是多少的!";
        }
    };

    @RequestMapping("/redis")
    public  ModelAndView redis(){
        Random r=new Random();
        logger.info("开始测试连接读取redis的操作{}", r.nextInt());
        ModelAndView mv=new ModelAndView();
         String url="/newOne";
        getJedisCluster();
        if(jedisCluster!=null&&jedisCluster.get("music")==null) {
            logger.error("redis的host:{}", redisConfig.getHostandport());
            jedisCluster.set("music", "turang");
        }
        threadLocal.set("两个不能共存了，恩");
        threadLocal.set("只能留下最后的了！");
        mv.addObject("ok","wo");
        mv.addObject("what",jedisCluster.get("music"));

        //在此处设置下sLocal的值，看看后面能否取出来
        AppContext.sLocal.set("redis is this......");
        AppContext.panda="2009";
        //mv.setViewName("forward:"+url);
        mv.setViewName("redirect:"+url);

        return  mv;

    }


    public   Set<HostAndPort> getHostAndPort(String hostAndPort){
        Set<HostAndPort> hap = new HashSet<HostAndPort>();
        String[] hosts = hostAndPort.split(",");
        String[] hs = null;
        for(String host:hosts){
            hs=host.split(":");
            hap.add(new HostAndPort(hs[0], Integer.parseInt(hs[1])));
        }
        return hap;
    }

    public  JedisCluster getJedisCluster(){
         //我用默认的，只要三个参数
        hostAndPorts = getHostAndPort(redisConfig.getHostandport());
        jedisCluster = new JedisCluster(hostAndPorts,redisConfig.getTimeout(),redisConfig.getMaxRedirections());
        return jedisCluster;
    }


}
