package com.guomin.demo1.service;

import com.guomin.demo1.Dao.DiscussPostMapper;
import com.guomin.demo1.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId,int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);

    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }


}
