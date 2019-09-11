package com.guomin.demo1;

import com.guomin.demo1.Dao.AlphaDao;
import com.guomin.demo1.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Demo1Application.class)//希望和正式环境的配置类用一样的
public class Demo1ApplicationTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        this.applicationContext=applicationContext;
    }

    @Test
    public void testApplicationContext(){

        System.out.println(applicationContext);//加载容器
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);//获取容器里面的类,如果多个类都是实现的AlphaDao，在想加载的类前加入@Primary
        System.out.println(alphaDao.select());
        //这么做的好处

        //
        alphaDao = applicationContext.getBean("daoimplement",AlphaDao.class);//加载指定容器
    }

    @Test
    public void testbeanmanage(){
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        //Spring 容器管理的bean默认是单例的
        //不想某个bean为单例这么办：在bean前面加上@Scope("prototype")默认参数为sinte
        //一般都只使用单例
        alphaService =  applicationContext.getBean(AlphaService.class);//这个和上面的alphaService是同一个对象的
        System.out.println("sencond"+alphaService);

        //如果想使用jar包里面的类：写配置类，通过注解声明
    }

    @Test
    public void  testBeanConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    //以上方法比较麻烦
    @Autowired
    private AlphaDao alphaDao;//这句话表示希望把alphadao注入到当前bean

    @Autowired
    private  AlphaService alphaService;
    @Test
    public void testDi(){
        System.out.println(alphaDao);
        System.out.println(alphaService);
    }

    //一般的调用步骤：controller -->service -->Dao(database)

}
