package com.guomin.demo1.Dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("daoimplement")//给bean取一个名字
@Primary
public class daoimplement implements AlphaDao {
    @Override
    public String select(){
        return "Hibernate";
    }
}

