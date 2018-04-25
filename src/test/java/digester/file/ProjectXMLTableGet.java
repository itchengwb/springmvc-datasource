package digester.file;

import com.noriental.utils.json.JsonUtil;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2017/9/29  17:56
 * Discribe: Template
 */
public class ProjectXMLTableGet {
    static  Set<String> set = new HashSet<String>();
    public static void main(String[] args) {
        String str ="/Users/colby/dev/workspace/praxis-svr/praxis-svr-main/src/main/resources/mappers/answer.chal.map.xml";

        String praxisFilepath = "/Users/colby/dev/workspace/praxis-svr/praxis-svr-main/src/main/resources/mappers/";//文件夹的目录
        String usrFilepath = "/Users/colby/dev/workspace/user-svr/user-svr-main/src/main/resources/mappers/";//文件夹的目录
        String adminsvr = "/Users/colby/dev/workspace/admin-svr/admin-svr-main/src/main/resources/mappers/";//文件夹的目录
        String encouragesvr = "/Users/colby/dev/workspace/encourage-svr/encourage-svr-main/src/main/resources/mappers";//文件夹的目录

        String imsvr = "/Users/colby/dev/workspace/im-svr/im-svr-main/src/main/resources/mappers";//文件夹的目录
        String lessonsvr = "/Users/colby/dev/workspace/lesson-svr/lesson-svr-main/src/main/resources/mappers";//文件夹的目录
        String messageSvr = "/Users/colby/dev/workspace/message-svr/message-svr-main/src/main/resources/mappers";//文件夹的目录
        String publicSvr = "/Users/colby/dev/workspace/public-svr/public-svr-main/src/main/resources/mappers";//文件夹的目录
        String pushsvr = "/Users/colby/dev/workspace/push-svr/push-svr-main/src/main/resources/mappers";//文件夹的目录
        String recommendsvr1 = "/Users/colby/dev/workspace/recommend-svr/recommend-svr-main/src/main/resources/mappers/report";//文件夹的目录
        String recommendsvr2 = "/Users/colby/dev/workspace/recommend-svr/recommend-svr-main/src/main/resources/mappers/slavev3";//文件夹的目录
        String securitysvr = "/Users/colby/dev/workspace/security-svr/security-svr-main/src/main/resources/mappers";//文件夹的目录
        //String solrsvr = "/Users/colby/dev/workspace/solr-svr/solr-svr-main/src/main/resources/mappers";//文件夹的目录
        String trailsvr = "/Users/colby/dev/workspace/trail-svr/trail-svr-main/src/main/resources/mappers";//文件夹的目录
        String solrsvr = "/Users/colby/dev/workspace_test/springmvc-datasource/src/main/Profiles/local";//文件夹的目录


        //getAllFile(praxisFilepath);
        //getAllFile(recommendsvr1);
        getAllFile(solrsvr);
        System.out.println(JsonUtil.obj2Json(set));
    }

    /**
     *获取所有的文件
     * @param path
     */
    public static void getAllFile(String path){
        File file = new File(path);//File类型可以是文件也可以是文件夹
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {//判断是否为文件
                //获取文件内容
                readFileByLines(fileList[i].toString());
                System.out.println(fileList[i]);
            }
            System.out.println("========");
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
                //&& (!tmpStr.contains("<!--") || !tmpStr.contains("-->"))
                String[] strArr = tmpStr.split(" ");
                if(tmpStr.contains("entity_") && !tmpStr.contains("<") &&!tmpStr.contains(">")){
                    for (int i = 0; i < strArr.length; i++) {
                        String s =strArr[i];
                        if (s.contains("entity_")) {
                            System.out.println("line:" + line + ": " + tmpStr);
                            //去掉"("
                            s = getString(s);
                            set.add(s);
                        }
                    }

                }else if(tmpStr.contains("link_") && !tmpStr.contains("<") &&!tmpStr.contains(">")){
                    for (int i = 0; i < strArr.length; i++) {
                        String s =strArr[i];
                        if (strArr[i].contains("link_")) {
                            System.out.println("line:" + line + ": " + tmpStr);
                            //去掉"("
                            s = getString(s);
                            set.add(s);
                        }
                    }
                }else if(tmpStr.contains("from ")&& !tmpStr.contains("<") &&!tmpStr.contains(">")){
                    for (int i = 0; i < strArr.length; i++) {

                        if (strArr[i].contains("from")) {
                            //System.out.println(strArr[i+1]);
                            System.out.println("line:" + line + ": " + tmpStr);
                            String s = null;
                            try {
                                s = strArr[i+1];
                                //去掉"("
                                s = getString(s);
                                set.add(s);
                            } catch (Exception e) {
                                System.out.println("index of arr");
                            }

                        }
                    }
                }else if( tmpStr.contains("into ")&& !tmpStr.contains("<") &&!tmpStr.contains(">")){
                    for (int i = 0; i < strArr.length; i++) {
                        if (strArr[i].contains("into")) {
                            //System.out.println(strArr[i+1]);
                            System.out.println("line:" + line + ": " + tmpStr);
                            String s =strArr[i+1];
                            //去掉"("
                            s = getString(s);
                            set.add(s);
                        }
                    }
                }else if( tmpStr.contains("update ")&& !tmpStr.contains("<") &&!tmpStr.contains(">")){
                    for (int i = 0; i < strArr.length; i++) {
                        if (strArr[i].contains("update")) {
                            //System.out.println(strArr[i+1]);
                            System.out.println("line:" + line + ": " + tmpStr);
                            String s = null;
                            try {
                                s = strArr[i+1];
                                //去掉"("
                                s = getString(s);
                                set.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }

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

    /**
     * 去掉"("
     * @param s
     * @return
     */
    public static String getString(String s){

        if(s.contains("(")){
            int num = s.indexOf("(");
            s = s.substring(0,num);

        }
        System.out.println(s);
        return  s;


    }

}
