package com.imooc.concurrency.jvm;

/**
 * @Author peterLee
 * @Date 2018/9/13 下午2:08
 * @Describtion :
 */
public class JvmProperties {

    public static void main(String[] args) {
        //=====================Begin=========================
        System.out.println("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024+"M");

        System.out.println("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024+"M");

        System.out.println("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024+"M");

        //=====================First Allocated=========================
        System.out.println("5MB array allocated");
        byte[] b1 = new byte[5*1024*1024];
        //=====================First Allocated end=========================
        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

        //=====================Second Allocated=========================
        System.out.println("10MB array allocated");
        byte[] b2 = new byte[10 * 1024 * 1024];
        //=====================Second Allocated end=========================

        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

        //=====================OOM=========================
        System.out.println("OOM!!!");
        System.gc();
        byte[] b3 = new byte[40 * 1024 * 1024];

    }
}
