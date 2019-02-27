package pers.xipiker.v3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获取成员方法并调用:
 * 1.批量:
 *      public Method[] getMethods():获取所有"公有方法";(包含了父类的方法也包含Object类);
 *      public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的);
 * 2.获取单个:
 * 		public Method getMethod(String name,Class<?>... parameterTypes)(获取公有):
 * 	    参数:
 * 	        name:方法名;
 * 	        Class...:形参的Class类型对象;
 * 	    public Method getDeclaredMethod(String name,Class<?>... parameterTypes)(获取私有)
 * 调用方法:
 *      Method --> public Object invoke(Object obj,Object... args):
 *      参数:
 *          obj:要调用方法的对象;
 *          args:调用方式时所传递的实参;
 */
public class MethodClazz {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取Class对象
        Class clazz = Class.forName("pers.xipiker.v3.Student");
        //2.获取所有"公有方法"
        System.out.println("******************获取所有公有方法****************");
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        //3.获取所有的成员方法，包括私有的(不包括继承的)
        System.out.println("******************获取所有的成员方法，包括私有的(不包括继承的)****************");
        methods = clazz.getDeclaredMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        //4.获取公有的show1()方法
        System.out.println("******************获取公有的show1()方法****************");
        Method m = clazz.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object object = clazz.getConstructor().newInstance();
        m.invoke(object, "xipiker");
        //5.获取私有的show4()方法
        System.out.println("******************获取私有的show4()方法****************");
        m = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        //解除私有限定
        m.setAccessible(true);
        Object object2 = m.invoke(object, 20);
        System.out.println("return:"+object2);
    }
}
