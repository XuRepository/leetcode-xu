package test;

import javax.sql.rowset.serial.SQLOutputImpl;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 21:20
 **/
public class class2 extends class1{
    private int id;

    public class2(String name, int id) {
        super(name);
        this.id = id;
    }


    public int getId(String s,int i) {
        System.out.println(s);
        System.out.println(i);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public class2(String name) {
        super(name);
    }

    public static void main(String[] args) {
        class2 class2 = new class2("xiaoming");
        System.out.println(class2.getName());


        class1 haha = new class2("haha", 1);
        System.out.println(haha.toString());
    }

//    @Override
//    public String toString() {
//        return "class2{" +
//                "id=" + id +
//                "} " + super.toString();
//    }
}
