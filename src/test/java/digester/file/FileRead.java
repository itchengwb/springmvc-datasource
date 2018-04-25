package digester.file;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  17:56
 * Discribe: Template
 */
public class FileRead {

    public static void main(String[] args) {

        String path = "//Users//colby//soft/tableName2.txt";
        //String retStr = readFile2("D:\\bb.txt","D:\\cc.txt");
        readFileByPath2(path);

        URI uri = null;
        /*try {
            uri = Thread.currentThread().getContextClassLoader()
                    .getResource(path).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }*/
        System.out.println(uri);
    }

    /**
     * 按行读文件,拼内容
     * @param fileName
     * @return
     */
    public static void readFileByPath2(String fileName){

        //List<String> list = new ArrayList<>();
        try {
            //获取文件路径
           /* URI uri = Thread.currentThread().getContextClassLoader()
                    .getResource(fileName).toURI();
            System.out.println(uri);*/

            File file = new File(fileName);
            if (!file.exists()) {
                return ;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            try {
                int count =0;

                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line!=null) {
                        String template = "select '', count(*) as count from   ";

                        count +=1;
                        template = template.replace("''","'"+line+"'") +" "+ line;
                        template = template +" where create_time >'2017-11-20 00:00:00'";
                        System.out.println(template);
                        //System.out.println("--");
                    }

                }
                System.out.println(count);
            } catch (Exception e) {
                System.out.println("readFile error."+e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("br close error."+e1);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("read file error."+e);
        }
        //return list;
    }

    /**
     * 按行读文件,拼内容
     * @param fileName
     * @return
     */
    public static void readFileByPath(String fileName){

        //List<String> list = new ArrayList<>();
        try {
            //获取文件路径
           /* URI uri = Thread.currentThread().getContextClassLoader()
                    .getResource(fileName).toURI();
            System.out.println(uri);*/

            File file = new File(fileName);
            if (!file.exists()) {
                return ;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            try {
                int count =0;

                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line!=null) {
                        String template = "union all select '', count(*) as count from ";

                        count +=1;
                        template = template.replace("''","'"+line+"'") +" "+ line;
                        System.out.println(template);
                    }

                }
                System.out.println(count);
            } catch (Exception e) {
                System.out.println("readFile error."+e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("br close error."+e1);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("read file error."+e);
        }
        //return list;
    }

    /**
     * 读取文件
     * @param fileName
     * @return
     */
    public static String readFile2(String fileName,String fileName2) {
        String  listKey = "list_prefix_1_";//levelId_workLevel";
        String retStr = "";
        if (fileName == null || fileName.trim().length() == 0) {
            return null;
        }
        List<String> list =read(fileName);
        List<String> list2 =read(fileName2);
        for (String o:list){
            if(!list2.contains(o)){
                System.out.println(o);
            }
        }

        return retStr;
    }

    public static List<String> read(String fileName){

        List<String> list = new ArrayList<>();
        try {
            //获取文件路径
           /* URI uri = Thread.currentThread().getContextClassLoader()
                    .getResource(fileName).toURI();
            System.out.println(uri);*/

            File file = new File(fileName);
            if (!file.exists()) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            try {
                int count =0;

                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line!=null) {
                        String s = "";
                       /* s += listKey+line+"_1\n";
                        s += listKey+line+"_2\n";
                        s += listKey+line+"_3\n";
                        retStr += s;*/
                        //System.out.println(s);
                        list.add(line);
                        count +=1;
                    }

                }
                System.out.println(count);
            } catch (Exception e) {
                System.out.println("readFile error."+e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("br close error."+e1);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("read file error."+e);
        }
        return list;
    }
    /**
     * 读取文件
     * @param fileName
     * @return
     */
    public static String readFile(String fileName) {
        String retStr = "";
        if (fileName == null || fileName.trim().length() == 0) {
            return null;
        }
        try {
            //获取文件路径
            URI uri = Thread.currentThread().getContextClassLoader()
                    .getResource(fileName).toURI();
            System.out.println(uri);

            File file = new File(uri);
            if (!file.exists()) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));


            try {
                int count =0;

                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line!=null) {
                        if(line.contains("serviceInterface")&& line.contains("com.fuscent.core.service")){
                            String s = line.substring(line.indexOf("<value>")+"<value>".length(),line.lastIndexOf("</value>"));
                            retStr += s+";";
                            System.out.println(s);
                            count +=1;
                        }
                    }

                }
                System.out.println(count);
            } catch (Exception e) {
                System.out.println("readFile error."+e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("br close error."+e1);
                    }
                }
            }
            return retStr;
        } catch (Exception e) {
            System.out.println("read file error."+e);
        }
        return retStr;
    }



}
