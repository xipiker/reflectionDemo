package pers.xipiker.v1;

public class Fanshe {
    public static void main(String[] args) {
        //第一种方法获取Class对象
        Student student = new Student(); //产生一个Student对象，一个Class对象
        Class stuClass = student.getClass(); //获取Class对象
        System.out.println(stuClass.getName());

        //第二种方法获取Class对象
        Class stuClass2 = Student.class;
        //这里来判断第一次和第二次获取是否为同一个
        System.out.println(stuClass == stuClass2);

        //第三种方法获取Class对象
        try {
            //这里路径需要指定包路径和class类路径
            Class stuClass3 = Class.forName("pers.xipiker.v1.Student");
            //这里来判断是否为同一个
            System.out.println(stuClass3 == stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
