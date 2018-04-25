package digester.clazz.xml;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  14:48
 * Discribe: Template
 */
public class ClazzDigester {

    public static void main(String[] args){

        String path = "file:\\dev\\workspace-yooli\\demo\\javaweb\\src\\applicationContext-spring-rmi-client.xml";

        Beans vc = digester(path);

        List<Bean> list =  vc.getBeanList();
        System.out.println("个数："+list.size());

        String str = "";
        int num = 0;
        for(Bean bean:list){
            String string = bean.getServiceInterface();
            if(string.contains("com.fuscent.core.service")){
                if(!"".equals(str) ){
                    str = str + ";" +string;
                }else{
                    str = string;
                }
                System.out.println(bean.getServiceInterface());
            }
            num = num + 1;
        }
        System.out.println("num= "+num+"==>"+str);

    }


    /**
     * 根据路径，解析applicationContext-spring-rmi-client.xml
     * @param path
     * @return
     */
    public static Beans digester(String path)  {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("beans", Beans.class);
        // 指明匹配模式和要创建的类
        digester.addObjectCreate("beans/bean", Bean.class);
        // 设置对象属性,与xml文件对应,不设置则是默认
        digester.addBeanPropertySetter("beans/bean/serviceInterface", "serviceInterface");
        digester.addBeanPropertySetter("beans/bean/property", "property");
        // 当移动到下一个标签中时的动作
        digester.addSetNext("beans/bean", "addBean");

        Beans vc = null;
        try {
            //注意路径
            vc = (Beans) digester.parse(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return vc;
    }
}
