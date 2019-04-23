package com.test.thread;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.dfcchina.common.util.DateFormatUtil;

/**
 * 变量
 * 
 * @author luke
 */
public class DemoTemp {

    public static final int count = 1000;

    private Date beginDate;

    private Date endDate;

    private DemoDB db;

    public DemoTemp() {
        // TODO Auto-generated constructor stub
    }

    public DemoTemp(DemoDB db) {
        this.db = db;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    void begin() {
        setBeginDate(new Date());
        System.out.println("BEGIN:" + DateFormatUtil.dateToString(getBeginDate(), DateFormatUtil.FORMAT_DATETIME));
    }

    void end() {
        while (db.getList().size() < count) {
            // System.out.println("go on..");
        }
        setEndDate(new Date());
        System.out.println("END:" + DateFormatUtil.dateToString(endDate, DateFormatUtil.FORMAT_DATETIME));
        System.out.println("db:" + db.getList().size() + ",耗时:" + (getEndDate().getTime() - getBeginDate().getTime()));

        // out();

    }

    void out() {
        System.out.println("========================data========================");
        DemoData temp;
        int size = db.getList().size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (db.getList().get(j).getId() > db.getList().get(j + 1).getId()) {
                    temp = db.getList().get(j);
                    db.getList().set(j, db.getList().get(j + 1));
                    db.getList().set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < db.getList().size(); i++) {
            System.out.println(JSONObject.toJSONString(db.getList().get(i)));
        }
    };

}
