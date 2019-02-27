package pers.xipiker.v3;

public class Student {
    public void show1(String s){
        System.out.println("show1-公有方法-s-" + s);
    }
    protected void show2(){
        System.out.println("show2-受保护方法-无参");
    }
    void show3(){
        System.out.println("show3-默认方法-无参");
    }
    private String show4(int age){
        System.out.println("show4-私有方法-age-" + age);
        return "xipiker";
    }
}
