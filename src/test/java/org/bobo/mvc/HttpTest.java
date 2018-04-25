package org.bobo.mvc;

import org.bobo.util.HttpUtils;

import java.util.HashMap;

/**
 * Discribe:
 * Project:springmvc-datasource
 * Package: org.bobo.mvc
 * User: Chengwenbo
 * Date:  2016/3/17
 * Time: .10:12
 */
public class HttpTest {
    public static void main(String[] args) {
        String url="http://localhost:8888/api/log/logprint";
        HashMap<String, String> params = new HashMap<String, String>();
        String log_body = "{\"test_body\": \"{\\\"app_info\\\":{\\\"app_id\\\":3,\\\"app_version\\\":\\\"\\\"},\\\"date_time\\\":\\\"1458113330104\\\",\\\"log_type\\\":5,\\\"operation_info\\\":{\\\"operation_target_id\\\":\\\"653\\\",\\\"operation_type\\\":4},\\\"question_info\\\":{\\\"answer_mode\\\":0,\\\"exersice_id\\\":\\\"653\\\",\\\"exersice_type\\\":0,\\\"question_list\\\":[{\\\"question_id\\\":\\\"2430490\\\",\\\"question_operation_time\\\":\\\"1458113319136\\\",\\\"question_operation_type\\\":1,\\\"question_type\\\":42},{\\\"question_id\\\":\\\"2430490\\\",\\\"question_operation_time\\\":\\\"1458113321821\\\",\\\"question_operation_type\\\":5,\\\"question_type\\\":42},{\\\"question_id\\\":\\\"2430490\\\",\\\"question_operation_time\\\":\\\"1458113322516\\\",\\\"question_operation_type\\\":3,\\\"question_type\\\":42}]},\\\"user_info\\\":{\\\"class_id\\\":\\\"\\\",\\\"uid\\\":\\\"67714\\\"}}\"}";
        params.put("log_body",log_body);

        try {
            String st = HttpUtils.sendPost(url,params);
            System.out.println(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
