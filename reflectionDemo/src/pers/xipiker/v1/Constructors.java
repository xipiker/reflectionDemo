package pers.xipiker.v1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过Class对象可以获取某个类中的:构造方法、成员变量、成员方法;并访问成员;
 * 1.获取构造方法:
 * 批量的方法:
 *     public Constructor[] getConstructors():所有"公有的"构造方法;
 *     public Constructor[] getDeclaredConstructors():获取所有的构造方法(包括私有、受保护、默认、公有);
 * 获取单个的方法:
 *     public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的、无参"的构造方法;
 *     public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有、无参;
 * 调用构造方法:
 *     Constructor-->newInstance(Object... initrags)
 *     newInstance(管理构造函数的类):使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
 *     它的返回值是T类型，所以newInstance是创建了一个构造方法的声明类的新实例对象。并为之调用
 */
public class Constructors {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.加载Class对象
        Class clazz = Class.forName("pers.xipiker.v1.Student");
        //2.获取所有"公有的"构造方法
        System.out.println("******************所有公有的构造方法****************");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }
        //3.获取所有的构造方法(包括私有、受保护、默认、公有)
        System.out.println("******************获取所有的构造方法(包括私有、受保护、默认、公有)****************");
        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor c : constructors1){
            System.out.println(c);
        }
        //4.获取单个的"公有、无参"构造方法
        System.out.println("******************获取单个的公有、无参构造方法****************");
        Constructor con = clazz.getConstructor(null);
        System.out.println(con);
        //Object obj = con.newInstance();
        //System.out.println("obj = " + obj);

        //5.获取私有构造方法，并调用
        System.out.println("******************获取私有构造方法，并调用****************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true); //暴力访问(忽略掉访问修饰符)
        Object obj = con.newInstance('男');
        //System.out.println(obj);
    }
}