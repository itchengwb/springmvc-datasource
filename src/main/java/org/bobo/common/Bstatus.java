package org.bobo.common;


import java.io.Serializable;

/**
 * wenbo.cheng
 */
public class Bstatus implements Serializable {

	private static final long serialVersionUID = 4637459385621476081L;

	private int code;

	private String des = "";

	private ActionResult action;
	public Bstatus(){}

	public Bstatus(int code, String des, ActionResult action){
		this.code = code;
		this.des = des;
		this.action = action;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public ActionResult getAction() {
		return action;
	}

	public void setAction(ActionResult action) {
		this.action = action;
	}
}
