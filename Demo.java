package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        // 普通
        // test();

        // 多线程(非线程池)
        // testThred();

        // 多线程(线程池)
        testThredPool();
    }

    /**
     * 普通写入
     */
    static void test() {
        DemoDB db = new DemoDB();
        DemoTemp temp = new DemoTemp(db);
        temp.begin();
        for (int i = 0; i < temp.count; i++) {
            DemoData data = new DemoData(i);
            // 写
            DemoWriter writer = new DemoWriter(db);
            writer.writer(data);
        }
        temp.end();
    }

    /**
     * 多线程写入(部分代码参考了网络dmeo)
     */
    static void testThred() {
        DemoDB db = new DemoDB();
        DemoTemp temp = new DemoTemp(db);
        temp.begin();
        // 获取当前程序运行时对象
        Runtime run = Runtime.getRuntime();
        // 调用垃圾回收机制，以减少内存误差
        run.gc();
        // 获取当前JVM的空闲内存
        long freeMemory = run.freeMemory();
        // 系统当前时间
        long timePro = System.currentTimeMillis();
        for (int i = 0; i < temp.count; i++) {
            DemoData data = new DemoData(i);
            // 写
            DemoWriterThread writer = new DemoWriterThread(db, data);
            // 【非线程池】
            new Thread(writer).start();
        }
        System.out.println("独立创建并执行" + temp.count + "个线程所需要占用的内存大小: " + (freeMemory - run.freeMemory()));
        System.out.println("独立创建并运行" + temp.count + "个线程需要的时间为: " + (System.currentTimeMillis() - timePro));
        temp.end();
    }

    /**
     * CPU核心数
     */
    private static final int CPU_CORE_NUM = 6;

    /**
     * 多线程池写入(部分代码参考了网络dmeo)
     */
    static void testThredPool() {
        DemoDB db = new DemoDB();
        DemoTemp temp = new DemoTemp(db);
        temp.begin();
        // 获取当前程序运行时对象
        Runtime run = Runtime.getRuntime();
        // 调用垃圾回收机制，以减少内存误差
        run.gc();
        // 获取当前JVM的空闲内存
        long freeMemory = run.freeMemory();
        // 系统当前时间
        long timePro = System.currentTimeMillis();
        // 【线程池】这里使用的公式：线程数 = CPU核心数/(1-阻塞系数)，阻塞系数取值：0.8
        int nThreads = CPU_CORE_NUM * 10 / 2;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < temp.count; i++) {
            DemoData data = new DemoData(i);
            // 写
            DemoWriterThread writer = new DemoWriterThread(db, data);
            // 【线程池】
            service.submit(writer);
        }
        System.out.println("使用线程池创建" + temp.count + "个线程所需要占用的内存大小: " + (freeMemory - run.freeMemory()));
        // 【线程池】线程池使用完成，关闭线程池
        service.shutdown();
        System.out.println("使用线程池创建并运行" + temp.count + "个线程需要的时间为: " + (System.currentTimeMillis() - timePro));
        temp.end();
    }

}
