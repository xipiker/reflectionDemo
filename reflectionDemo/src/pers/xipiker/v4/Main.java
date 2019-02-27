package pers.xipiker.v4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.获取Student对象的字节码
        Class clazz = Class.forName("pers.xipiker.v4.Student");
        //2.获取main方法
        Method method = clazz.getMethod("main", String[].class);
        //3.调用main方法
        method.invoke(null, (Object)new String[]{"a","b"});
    }
}
