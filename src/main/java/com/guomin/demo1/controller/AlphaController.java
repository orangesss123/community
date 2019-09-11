package com.guomin.demo1.controller;

import com.guomin.demo1.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller  //可以被扫描并装入容器中
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/mainpage")
    @ResponseBody
    public String sayhello(){
        return "welcom to 国旻社区";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }


        System.out.println(request.getParameter("code"));
        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try( PrintWriter writer =response.getWriter();){
            writer.write("<h1>国旻网页</h1>");//输出一个一级标题
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //如何接收请求数据，GET,用于获取某些收据，默认的请求为GET请求
    // /students?current=1&limit=20 (数据比较多，分页显示)

    @RequestMapping(path = "/students",method = RequestMethod.GET)//限制请求为get
    @ResponseBody
    public String getStudents(
            @RequestParam(name ="current",required = false,defaultValue = "1") int current,
            @RequestParam(name ="limit",required = false,defaultValue = "10")int limit){//dispacherSeverlet会直接将curr=1&limit=20 对应的值赋值

        System.out.println(current);
        System.out.println(limit);
        return "Student form";
    }

    //获取参数的不同方法
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //浏览器向服务器提交数据 POST
    //首先服务器得获得有表单的网页
    //先创建一个静态的网页
    //get也可提交表单，为什么不用呢？首先：get请求会把数据放在明面上，即请求路径中，但请求路径长度有限
    //POST
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){//参数名和表单一致就可以传进来
        System.out.println(name);
        System.out.println(age);
        return "sucess";
    }

    //如何向浏览器响应html数据

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        //返回model and view
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","zhangsan");
        mav.addObject("age","30");

        //设置一个模版。themyleaf 默认模版为html
        mav.setViewName("/demo/view");
        return mav;
    }


}
