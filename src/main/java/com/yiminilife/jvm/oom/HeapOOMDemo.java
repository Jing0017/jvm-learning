package com.yiminilife.jvm.oom;

import java.util.ArrayList;

/**
 * @author yanjing
 * date: 2019/12/11
 * description:
 * jvm param
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./ -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 */
public class HeapOOMDemo {

    public static void main(String[] args) {
        long counter = 0;
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
            System.out.println("当前创建了第" + (++counter) + "个对象");
        }
    }
}
