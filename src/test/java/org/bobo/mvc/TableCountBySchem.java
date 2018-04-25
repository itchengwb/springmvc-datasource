package org.bobo.mvc;

import java.io.*;
import java.util.*;

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
        String pat1 = "D:\\统计sql.txt";
        String path2 = "D:\\export_sql";
        String path3 = "D:\\counter_res.sql";
        String path41 = "D:\\1.txt";
        String path42 = "D:\\2.txt";

        //getFilePath(path3);
        //read(path);
        //read2(path2);
        //read3(path3);
        //read4(path41,path42);


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
