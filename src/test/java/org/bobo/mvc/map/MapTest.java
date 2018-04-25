package org.bobo.mvc.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bobo on 2015/10/29.
 */
public class MapTest {

    public static void main(String[] args){
        Map m = new HashMap();
        m.put("key","hello");
        m.put("key2","hello");
        m.put("key3","hello");

        System.out.println(m.get("key"));
        System.out.println(m.get("aa"));
        System.out.println(m);
       /* JSONObject jsonObject = JSON.parseObject(m.toString());
        System.out.println(jsonObject);*/
    }
}
