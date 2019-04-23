package com.test.thread;

/**
 * 数据对象
 * 
 * @author luke
 */
public class DemoData {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoData() {
        // TODO Auto-generated constructor stub
    }

    public DemoData(int index) {
        this.id = index;
        this.name = "客户" + index;
    }

}
