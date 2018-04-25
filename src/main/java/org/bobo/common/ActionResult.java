package org.bobo.common;

import java.io.Serializable;
import java.util.List;

/**
 * 页面跳转类
 * pageto：页面跳转
 * resets：输入项重置
 * @author wenbo.cheng
 *
 */
public class ActionResult implements Serializable {

	private static final long serialVersionUID = 4637458385621476081L;

	private int pageto;
	private List<Integer> resets;

	public int getPageto() {
		return pageto;
	}

	public void setPageto(int pageto) {
		this.pageto = pageto;
	}

	public List<Integer> getResets() {
		return resets;
	}

	public void setResets(List<Integer> resets) {
		this.resets = resets;
	}

}
