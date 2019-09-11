package com.guomin.demo1.controller;

import com.guomin.demo1.entity.DiscussPost;
import com.guomin.demo1.entity.User;
import com.guomin.demo1.entity.page;
import com.guomin.demo1.service.DiscussPostService;
import com.guomin.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//controller访问路径可以设为空
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)//方法的访问路径
    public String getIndexPage(Model model, page page) {

        //方法调用之前，springMVC会自动实例化Model和page,page注入到model中
        //所以，在page中可以直接访问page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> posts = discussPostService.findDiscussPost(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussposts = new ArrayList<>();
        if (posts != null) {
            for (DiscussPost post : posts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussposts.add(map);
            }
        }
        model.addAttribute("discussPost", discussposts);
        return "/index";//返回视图的名字
    }//因为响应的是网页，所以不需要responseBody
}
