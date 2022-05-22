package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 21:20
 **/
public class class1 {
    private String name;

    public class1() {
    }

    public class1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "class1{" +
                "name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz =class2.class;
        class2 newC2 = (class2)clazz.newInstance();

        Method getId = clazz.getDeclaredMethod("getId", String.class, int.class);

        Object haha = getId.invoke(newC2, "haha", 1);


    }
}
