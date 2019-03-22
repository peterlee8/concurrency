package com.imooc.concurrency.classes.demo;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 * 反射演示
 */
public class ExampleObject extends FatherObject{

    public int age = 30;
    public String name = "byhieg";
    private Integer score = 60;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ExampleObject() {
    }

    public ExampleObject(String name) {
        this.name = name;
    }

    public ExampleObject(int age, Integer score) {
        this.age = age;
        this.score = score;
    }

    @Override
    public void run() {
        System.out.println("run ......");
    }

    @Override
    public void doSomething() {
        super.doSomething();
    }

    @Override
    public String toString() {
        return "ExampleObject{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
