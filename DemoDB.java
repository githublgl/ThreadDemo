package com.test.thread;

import java.util.List;
import java.util.Vector;

/**
 * 模拟数据库
 * 
 * @author luke
 */
public class DemoDB {

    // private List<DemoData> list = new ArrayList<DemoData>();

    private List<DemoData> list = new Vector<DemoData>();

    public List<DemoData> getList() {
        return list;
    }

    public void setList(List<DemoData> list) {
        this.list = list;
    }

}
