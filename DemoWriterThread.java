package com.test.thread;

/**
 * 写入(线程)
 * 
 * @author luke
 */
public class DemoWriterThread implements Runnable {

    private DemoDB db;

    private DemoData data;

    public DemoWriterThread() {
    }

    public DemoWriterThread(DemoDB db, DemoData data) {
        this.db = db;
        this.data = data;
    }

    synchronized void writer() {
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

    @Override
    public void run() {
        writer();
    }

}
