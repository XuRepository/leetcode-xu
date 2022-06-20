import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 21:13
 **/
public class test {
//    public static void main(String[] args) {
//        ParamTest pt = new ParamTest();
//        User hollis = new User();
//        hollis.setName("Hollis");
//        hollis.setGender("Male");
//        pt.pass(hollis);
//        System.out.println("print in main , user is " + hollis);
//    }
//    public void pass(User user) {
//        user = new User();
//    user.setName("hollischuang");
//    user.setGender("Male");
//    System.out.println("print in pass , user is " + user);
//    }

    //print in pass , user is User{name='hollischuang', gender='Male'}
    // print in main , user is User{name='Hollis', gender='Male'}

    class Person{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void test(){
        ArrayList<Person> i = new ArrayList<Person>();
        i.add(new Person("xiaoming"));

        Person[] people = i.toArray(new Person[0]);
        people[0].setName("xiaohong");

        System.out.println(i.get(0).getName());
        System.out.println(people[0].getName());
    }

    @Test
    public void test1(){
        System.out.println(Integer.MAX_VALUE);
//        HashMap
    }

    @Test
    public void test2(){
    }

    @Test
    public void test11(){
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println(i1 == i3);
    }

    int max = 0;

//    public int dfs(TreeNode root){
//
//        //出口：
//        if (root == null) return 0;
//
//        int min = Integer.MAX_VALUE;
//
//        if (root.left != null){
//            int left = dfs(root.left);
//            min = 1+left;
//        }
//        if (root.right != null){
//            int right = dfs(root.right);
//            if (min>right+1){
//                min = 1+right;
//            }
    }


