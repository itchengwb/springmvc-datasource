package digester.clazz.method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  1:48
 * Discribe: Template
 */
public class FileCount {
    public static void main(String[] args) {
       String path = "";

    }

    /**
     * 获取目录下所有文件
     * @param path
     */
    public static void getFileInfo(String path){
        File file = new File(path);
        try {
            FileInputStream in = new FileInputStream(file);
            while (in.read() != -1){
                //String string = in.;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
