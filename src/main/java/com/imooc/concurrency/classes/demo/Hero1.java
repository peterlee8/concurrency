package com.imooc.concurrency.classes.demo;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 */
public class Hero1 {

    public String name;
    public float hp;
    public int damage;
    public int it;
    private int sex;

    static String copyright;

    static {
        System.out.println("初始化-copyright");
        copyright="初始化-copyright";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Hero1(){

    }
    public Hero1(String string) {
        name =string;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }

    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void attackHero(Hero1 h2) {
        System.out.println(this.name+ " 正在攻击 " + h2.getName());
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
