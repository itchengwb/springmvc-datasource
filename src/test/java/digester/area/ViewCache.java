package digester.area;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  0:51
 * Discribe: Template
 */
public class ViewCache {
    private List<Area> areaList = new ArrayList<Area>();
    public List<Area>  getAreaList() {
        return areaList;
    }
    public void setAreaList(List<Area>  areaList) {
        this.areaList = areaList;
    }

    // 供Digester调用的方法
    public void addArea(Area area) {
        this.areaList.add(area);
    }
}
