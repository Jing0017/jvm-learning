package com.yiminilife.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanjing
 * date: 2019/12/10
 * description:
 */
public class MatDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Data> datas = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }

    static class Data {

    }
}
