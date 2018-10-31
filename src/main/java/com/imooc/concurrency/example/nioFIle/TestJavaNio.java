package com.imooc.concurrency.example.nioFIle;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author peterLee
 * @CreateDate 2018/10/30
 * @Description
 */
public class TestJavaNio {

    static void readAndWriteNIO(){
        String pathName ="C:\\Users\\ASUS\\Desktop\\artonline2.zip";

        FileInputStream fin =null;

        String fileName = "C:\\Users\\ASUS\\Desktop\\test\\artonline2.zip";

        FileOutputStream fos =null;

        try {
            fin =new FileInputStream(new File(pathName));
            FileChannel channel = fin.getChannel();

            int capacity =1024 ;// 1024字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity()+ "位置是：" + bf.position());
            int length = -1;

            fos =new FileOutputStream(new File(fileName));

            FileChannel outChannel = fos.getChannel();

            while ((length =channel.read(bf))!= -1){
                //将当前位置为limit，然后设置当前位置为0，也就是从0到limit这块，都写入到通道中
                bf.flip();

                int outlength =0;
                while ((outlength=outChannel.write(bf))!=0){
                    System.out.println("读，"+length+"写,"+outlength);
                }

                //将当前位置置为0，然后设置limit为容量，也就是从0到limit（容量）这块，
                //都可以利用，通道读取的数据存储到
                //0到limit这块
                bf.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fin!=null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        long s =System.currentTimeMillis();
        readAndWriteNIO();
        long e =System.currentTimeMillis();
        System.out.println("花费时间："+(e-s));
    }
}
