package digester.file;

import com.noriental.utils.json.JsonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2017/9/29  17:56
 * Discribe: 获取所有使用redisUtil的class 以及使用的行
 */
public class RedisUtilCount {
    static  Set<String> set = new HashSet<String>();

    public static void main(String[] args) {

        String praxisFilepath = "/Users/colby/dev/workspace/praxis-svr/praxis-svr-main/src/main/java";//文件夹的目录



        /*System.out.println(JsonUtil.obj2Json(set));

        //D盘下的file文件夹的目录
        File file = new File(praxisFilepath);//File类型可以是文件也可以是文件夹
        File[] fileList = file.listFiles();

        List<File> wjjList = new ArrayList<File>();//新建一个文件夹集合
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {//判断是否为文件夹
                wjjList .add(fileList[i]);
                getAllFile(praxisFilepath);
            }
        }*/
        tt(praxisFilepath);

    }

    public static void tt(String path){
        System.out.println("========================================================================");
        //String path="d:/";
        File file=new File(path);
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
     *获取所有的文件
     * @param path
     */
    public static void getAllFile(String path){
        File file = new File(path);//File类型可以是文件也可以是文件夹
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            System.out.println("===="+fileList[i].toString()+"====");
            readFileByLines(fileList[i].toString());

        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tmpStr = null;
            int line = 1;

            // 一次读入一行，直到读入null为文件结束
            while ((tmpStr = reader.readLine()) != null) {
                tmpStr =tmpStr.toLowerCase();
                // 显示行号
                if(tmpStr.contains("redisUtil")){
                    System.out.println("line:" + line + ": " + tmpStr);
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

    }


}
