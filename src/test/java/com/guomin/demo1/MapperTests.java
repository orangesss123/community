package com.guomin.demo1;

import com.guomin.demo1.Dao.DiscussPostMapper;
import com.guomin.demo1.Dao.UserMapper;
import com.guomin.demo1.entity.DiscussPost;
import com.guomin.demo1.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Demo1Application.class)//希望和正式环境的配置类用一样的
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
       User user = userMapper.selectById(101);
       System.out.println(user);

       user = userMapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("1234");
        user.setSalt("abc");
        user.setEmail("cxy@sina.com");
        user.setHeaderUrl("http://www.nowcode.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(150,1);//返回修改的行数
        System.out.println(rows);
        rows = userMapper.updateHeader(150,"http://www.nowcode.com/102.png");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost res:list)
            System.out.println(res);

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }


}
