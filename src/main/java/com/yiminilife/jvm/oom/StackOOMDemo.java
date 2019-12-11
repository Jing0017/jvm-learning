package com.yiminilife.jvm.oom;

/**
 * @author yanjing
 * date: 2019/12/11
 * description:
 * jvm param
 * -XX:ThreadStackSize=1m
 */
public class StackOOMDemo {
    public static long counter = 0;

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        System.out.println("目前是第" + (++counter) + "次调用方法");
        work();
    }
}
