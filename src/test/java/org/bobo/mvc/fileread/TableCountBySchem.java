package org.bobo.mvc.fileread;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Discribe:
 * Project:springmvc-datasource
 * Package: org.bobo.mvc
 * User: Chengwenbo
 * Date:  2016/1/31
 * Time: .11:54
 */
public class TableCountBySchem {

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //String pat1 = "D:\\统计sql.txt";

        //getFilePath(path3);
        //read(path);
        //read2(path2);
        //read3(path3);
        //read4(path41,path42);
        //readWWrite();

        String str ="1.0.0.0         1.0.0.0         美国 亚太互联网络信息中心(CloudFlare节点)";
        String[] arr = str.split(" ");
        for(String t:arr){
            //System.out.println("=="+t+"=");
            if(t != " "){
                System.out.println("=="+t+"=");
            }
        }


    }

    /**
     * 读写文件
     */
    public static void readWWrite() {

        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;

        int count = 0;//写文件行数
        String path = "/Users/colby/Desktop/ip-data-new.txt";
        File file = new File(path);
        BufferedReader br = null;


        try {
            //读
            long begin0 = System.currentTimeMillis();
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            //写
            outSTr = new FileOutputStream(new File("/Users/colby/Desktop/ip.txt"));
            Buff = new BufferedOutputStream(outSTr);

            Map<String,Integer> map = new HashMap<>();
            String line = null;
            String space = " ";


            while ((line = br.readLine()) != null) {
                count = count +1;

                if(line.contains(space)){
                    //Buff.write("测试java 文件操作\r\n".getBytes());
                    Buff.write((line+"\n").getBytes());

                    System.out.println(line);
                }else{

                }
                if(count == 1000){
                    break;
                }
            }
            long end0 = System.currentTimeMillis();
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 毫秒");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Buff.close();
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("br close error."+e1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



    /**
     * 写文件
     */
    public static void write() {

        FileOutputStream out = null;
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        FileWriter fw = null;

        int count = 1000;//写文件行数

        try {

            //经过测试：ufferedOutputStream执行耗时:1,1，1 毫秒
            outSTr = new FileOutputStream(new File("C:\\Users\\lee\\Desktop\\add0.txt"));
            Buff = new BufferedOutputStream(outSTr);
            long begin0 = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                Buff.write("测试java 文件操作\r\n".getBytes());
            }
            Buff.flush();
            Buff.close();
            long end0 = System.currentTimeMillis();
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 毫秒");

           /* //经过测试：FileOutputStream执行耗时:17，6，10 毫秒
            out = new FileOutputStream(new File("C:\\Users\\lee\\Desktop\\add.txt"));
            long begin = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                out.write("测试java 文件操作\r\n".getBytes());
            }
            out.close();
            long end = System.currentTimeMillis();
            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 毫秒");

            //经过测试：ufferedOutputStream执行耗时:1,1，1 毫秒
            outSTr = new FileOutputStream(new File("C:\\Users\\lee\\Desktop\\add0.txt"));
            Buff = new BufferedOutputStream(outSTr);
            long begin0 = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                Buff.write("测试java 文件操作\r\n".getBytes());
            }
            Buff.flush();
            Buff.close();
            long end0 = System.currentTimeMillis();
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 毫秒");

            //经过测试：FileWriter执行耗时:3,9，5 毫秒
            fw = new FileWriter("C:\\Users\\lee\\Desktop\\add2.txt");
            long begin3 = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                fw.write("测试java 文件操作\r\n");
            }
            fw.close();
            long end3 = System.currentTimeMillis();
            System.out.println("FileWriter执行耗时:" + (end3 - begin3) + " 毫秒");*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                Buff.close();
                outSTr.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取目录下的文件
     */
    public static void getFilePath(String path){
        File file=new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数："+tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                String filePath = tempList[i].getPath();
                System.out.println("source " + filePath);
                //read(filePath);
            }else  if (tempList[i].isDirectory()) {
                System.out.println("文件夹：" + tempList[i]);
            }
        }
    }

     /**
     *读文件
     */
    public static void read(String path) {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            Map<String,Integer> map = new HashMap<>();
            try {
                String line = null;
                String from = "from";
                String where = "where";
                String parrten = "=";

                while ((line = br.readLine()) != null) {
                    if(line.contains(from) && line.contains(where)){
                        int num1 = line.indexOf(from);
                        int num2 = line.indexOf(where);
                        int num3 = line.indexOf(parrten);


                        String str1 = line.substring(0,num1);
                        String tableName = line.substring(num1+from.length(),num2).trim();
                        String str2 = line.substring(num2);
                        String str3 = line.substring(num3+1);

                        String strPrint = str1+",'" + tableName + "',"+ str3 + " " +from +"  "+ tableName+" "+str2;

                        System.out.println(strPrint);
                    }
                }
            } catch (Exception e) {
                System.out.println();
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     *读文件
     */
    public static void read2(String path) {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            Map<String,Integer> map = new HashMap<>();
            try {
                String line = null;
                String patrer = "VALUES";

                while ((line = br.readLine()) != null) {
                    if(line.contains("patrer")){
                        String[] strs = line.split(",");
                        line = strs[0] ;
                        String strPrint = line + ";";
                        System.out.println(strPrint);
                    }
                }
            } catch (Exception e) {
                System.out.println();
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     *读文件
     */
    public static void read3(String path) {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            Map<String,Integer> map = new HashMap<>();
            try {
                String line = null;
                String from = "from";
                String where = "where";
                String parrten = "=";

                while ((line = br.readLine()) != null) {
                    if(line.contains(from) && line.contains(where)){
                        String strPrint = line + ";";
                        System.out.println(strPrint);
                    }
                }
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
