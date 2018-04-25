package digester.area;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  0:52
 * Discribe: Template
 */
public class AreaDigester {public static void main(String[] args){

    String path = "file:\\dev\\workspace-yooli\\demo\\javaweb\\src\\area.xml";

    ViewCache vc = digester(path);

    List<Area> list =  vc.getAreaList();
    System.out.println("个数："+vc.getAreaList().size());

    for(Area area:list){
        System.out.println(area.getName());
    }

}

    public static ViewCache digester(String path)  {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("beans", ViewCache.class);
        // 指明匹配模式和要创建的类
        digester.addObjectCreate("viewcache/areas/area", Area.class);
        // 设置对象属性,与xml文件对应,不设置则是默认
        digester.addBeanPropertySetter("viewcache/areas/area/id", "id");
        digester.addBeanPropertySetter("viewcache/areas/area/parentId", "parentId");
        digester.addBeanPropertySetter("viewcache/areas/area/name", "name");
        digester.addBeanPropertySetter("viewcache/areas/area/areaType", "areaType");
        digester.addBeanPropertySetter("viewcache/areas/area/ordering", "ordering");
        digester.addBeanPropertySetter("viewcache/areas/area/zip", "zip");
        digester.addBeanPropertySetter("viewcache/areas/area/phoneArea", "phoneArea");
        // 当移动到下一个标签中时的动作
        digester.addSetNext("viewcache/areas/area", "addArea");

        ViewCache vc = null;
        try {
            //注意路径
            vc = (ViewCache) digester.parse(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return vc;
    }
}
