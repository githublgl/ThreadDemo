package com.test.thread;

/**
 * 写入(非线程)
 * 
 * @author luke
 */
public class DemoWriter {

    private DemoDB db;

    public DemoWriter() {
    }

    public DemoWriter(DemoDB db) {
        this.db = db;
    }

    synchronized void writer(DemoData data) {
        if (data != null) {
            db.getList().add(data);
            System.out.println("list:" + db.getList().size());
        }
        // 模拟数据库写入时间
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
