package pers.xipiker.v2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取成员变量并调用:
 * 1.批量:
 *      Field[] getFields():获取所有的"公有字段";
 *      Field[] getDeclaredFields():获取所有字段，包括:私有、受保护、默认、公有;
 * 2.获取单个:
 *      public Field getField(String fieldName):获取某个"公有的"字段;
 * 		public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的);
 * 设置字段的值:
 *      Field --> public void set(Object obj,Object value):
 *      参数说明:
 *          obj:要设置的字段所在的对象;
 *          value:要为字段设置的值;
 */
public class Fields {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取Class对象
        Class clazz = Class.forName("pers.xipiker.v2.Student");
        //2.获取所有公有字段
        System.out.println("******************获取所有公有字段****************");
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        //3.获取所有字段，包括:私有、受保护、默认、公有
        System.out.println("******************获取所有字段，包括:私有、受保护、默认、公有****************");
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f : fields1){
            System.out.println(f);
        }
        //4.获取某个"公有的"字段
        System.out.println("******************获取某个公有的字段****************");
        //可以试验一下把name改为私有变量phoneNum，将会报java.lang.NoSuchFieldException这个异常
        Field f = clazz.getField("name");
        System.out.println(f);
        //获取一个对象，产生Student对象等同于(Student stu = new Student();)
        Object object = clazz.getConstructor().newInstance();
        f.set(object, "xipiker");
        //验证
        Student student = (Student)object;
        System.out.println("验证:" + student.name);
        //5.获取某个字段(可以是私有的)
        f = clazz.getDeclaredField("phoneNum");
        System.out.println(f);
        //暴力反射，接触私有限定，没有加的话会报java.lang.IllegalAccessException这个异常
        f.setAccessible(true);
        f.set(object, "13513513513");
        System.out.println("验证电话：" + student);
    }
}
