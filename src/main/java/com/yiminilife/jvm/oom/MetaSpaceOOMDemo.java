package com.yiminilife.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author yanjing
 * date: 2019/12/11
 * description:
 * jvm param
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class MetaSpaceOOMDemo {
    public static void main(String[] args) {
        long counter = 0;
        while (true) {
            System.out.println("目前创建了" + (++counter) + "个Car子类");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (Objects.equals("run", method.getName())) {
                        System.out.println("安全检查......");
                        return methodProxy.invokeSuper(o, objects);
                    } else {
                        return methodProxy.invokeSuper(o, objects);
                    }
                }
            });

            Car car = (Car) enhancer.create();
            car.run();
        }
    }

    static class Car {
        public void run() {
            System.out.println("汽车启动，开始行使");
        }
    }
}
