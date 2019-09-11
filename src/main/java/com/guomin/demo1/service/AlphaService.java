package com.guomin.demo1.service;

import com.guomin.demo1.Dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService(){
        System.out.println("实例化");
    }

    @PostConstruct  //声明为初始化方法，在构造器后使用
    public void init(){
        System.out.println("初始化");
    }

    @PreDestroy   //在对象销毁之前使用
    public void destory(){
        System.out.println("销毁一些方法");
    }

    public String find(){
        return alphaDao.select();
    }
}
