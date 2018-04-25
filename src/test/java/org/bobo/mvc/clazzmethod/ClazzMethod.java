package org.bobo.mvc.clazzmethod;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  1:48
 * Discribe: Template
 */
public class ClazzMethod {
    public static void main(String[] args) {
        //获取包下面所有方法
        getMethodInfo("java.util.HashSet");

        //获取文件夹下面所有的文件：
        //D:\dev\workspace-yooli\core\core\yooli-api\src\main\java\com\fuscent\core\service
        String path = "D:\\dev\\workspace-yooli\\core\\core\\yooli-api\\src\\main\\java\\com\\fuscent\\core\\service";
        getFileInfo(path);

    }

    /**
     * 获取目录下所有文件
     * @param path
     */
    public static void getFileInfo(String path){
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数："+tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文     件："+tempList[i]);
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹："+tempList[i]);
            }
        }
    }
    /**
     * 传入全类名获得对应类中所有方法名和参数名
     */
    @SuppressWarnings("rawtypes")
    private static void getMethodInfo(String pkgName) {
        try {
            Class clazz = Class.forName(pkgName);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();

                Class<?>[] parameterTypes = method.getParameterTypes();
                String parms = "";
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    parms = ""+parms+parameterName;
                    //System.out.println("参数名称:" + parameterName);
                }
                System.out.println("方法名称:" + methodName+"("+parms+")");
               // System.out.println("*****************************");
            }
            System.out.println("方法总个数："+methods.length);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
