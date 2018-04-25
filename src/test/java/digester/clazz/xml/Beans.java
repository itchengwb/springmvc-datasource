package digester.clazz.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  15:14
 * Discribe: Template
 */
public class Beans {
    private List<Bean> beanList = new ArrayList<Bean>();

    public List<Bean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Bean> beanList) {
        this.beanList = beanList;
    }

    // 供Digester调用的方法
    public void addBean(Bean bean) {
        this.beanList.add(bean);
    }
}
