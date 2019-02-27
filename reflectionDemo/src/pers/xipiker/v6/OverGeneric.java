package pers.xipiker.v6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *  通过反射越过泛型检查
 *  例如:有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值?
 */
public class OverGeneric {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        list.add("xipiker1");
        list.add("xipiker2");
        //插入Integer类型
        Class listClass = list.getClass();
        Method m = listClass.getMethod("add", Object.class);
        m.invoke(list, 100);
        //遍历集合
        for(Object object : list){
            System.out.println(object);
        }
    }
}
