package pers.xipiker.v5;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改，
 * 只需要将新类发送给客户端，并修改配置文件即可。
 */
public class ReflectLodFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(getValue("className"));
        Method method = clazz.getMethod(getValue("methodName"));
        method.invoke(clazz.getConstructor().newInstance());
    }

    //获取配置文件相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();
        //这里指定文件的绝对路径
        FileReader in = new FileReader("/Users/mac/Desktop/pro.txt");
        pro.load(in);
        in.close();
        return pro.getProperty(key);
    }
}
