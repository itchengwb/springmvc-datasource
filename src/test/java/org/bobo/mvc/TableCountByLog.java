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
public class TableCountByLog {

    public static Set<String> set = new HashSet<String>();
    public static Set<String> setTableId = new HashSet<String>();
    public static Map<String,String> map = new HashMap<String,String>();


    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        String path = "D:\\logs\\";
        getFilePath(path);
        print();
        /*String str = "#160105 17:06:44 server id 3  end_log_pos 270058426 CRC32 0xcaff8c44 \tUpdate_rows: table id 110 flags: STMT_END_F";
        String str2 = "#160101  0:16:46 server id 3  end_log_pos 129370575 CRC32 0x45eb4c5c 	Table_map: `neworiental_v3`.`counter_res` mapped to number 110";

        String patten = "Update_rows: table id";
        int t1 = str.indexOf(patten);
        int t2 = str.indexOf("flags");
        System.out.println(str.substring(t1+patten.length(),t2));*/

        /*String pa = "mapped to number";
        int t3 = str2.indexOf(pa);
        System.out.println(str2.substring(t3+pa.length()));*/




    }

    /**
     *print
     */
    public static void print(){
        System.out.println("size="+set.size());
        List<String> list = new ArrayList<String>();
        for(String str:set){
            list.add(str);
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            //System.out.println((i+1)+":"+list.get(i));
            System.out.println(list.get(i));
        }

        System.out.println("setTableId="+setTableId);
        System.out.println("map="+map);
        System.out.println("====更新的表==="+setTableId.size());
        for(String s:setTableId){
            System.out.println(map.get(s));
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
                System.out.println("文件：" + filePath);
                read(filePath);
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
            try {
                String line = null;
                String parrtenV3 = "neworiental_v3";
                String parrtenMapped = "mapped";
                String updateRows = "Update_rows: table id";
                String mapped = "mapped to number ";

                while ((line = br.readLine()) != null) {
                    if(line.contains(parrtenV3)){
                        int num1 = line.indexOf(parrtenV3);
                        int num2 = line.indexOf(parrtenMapped);
                        String tableName = line.substring(num1+parrtenV3.length()+3,num2-2);
                        String tableId = line.substring(line.indexOf(mapped)+mapped.length()).trim();
                        //line = line.substring(num1,num2);
                        set.add(tableName);
                        //System.out.println(line);
                        map.put(tableId,tableName);

                    }else if(line.contains(updateRows)){
                        String flags = "flags";

                        if(line.contains(updateRows)&& line.contains(flags)){
                            int n1 = line.indexOf(updateRows);
                            int n2 = line.indexOf(flags);
                            line = line.substring(n1+updateRows.length(),n2).trim();
                            String tableId = line;
                            //System.out.println(tableId);
                            setTableId.add(tableId);
                        }
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

}
