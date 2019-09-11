package com.guomin.demo1.entity;
/*
封装分页相关的信息
 */
public class page {

    //当前的页码
    private int current=1;//default:10
    private int limit=10;//显示上限
    private int rows;//数据总数（计算总的页数）
    private String path;//查询路径（复用分页的连接）

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1)
           this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1&&limit<=100)
        this.limit = limit;
    }

    public int getRows() {

        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0)
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset(){
        return (current-1)*limit;
    }

    /**
     * 用来获取总的页数
     * @return
     */
    public int getTotal(){
        if(rows%limit==0)
            return rows/limit;
        else
            return rows/limit+1;
    }

    /**
     * 获取起始页码
     * @return
     */
    //从多少页显示到多少页
    public int getFrom(){
        int from=current-2>0?current-2:0;
        return from;
    }

    public int getTo(){
        int to = current+2>getTotal()?getTotal():current+2;
        return to;
    }
}
