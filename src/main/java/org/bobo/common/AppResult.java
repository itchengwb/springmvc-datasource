package org.bobo.common;

import java.io.Serializable;

/**
 * Created by wenbo.cheng
 * 2015/3/3.
 */
public class AppResult<T>  implements Serializable {

    private static final long serialVersionUID = 4637459385621476082L;

    private Bstatus bstatus;
    private T data;

    public AppResult() {
    }

    public AppResult(Bstatus status, T result) {
        this.bstatus = status;
        this.setData(result);
    }

    public Bstatus getBstatus() {
        return bstatus;
    }

    public void setBstatus(Bstatus bstatus) {
        this.bstatus = bstatus;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "AppResult [status=" + this.bstatus + ", data=" + this.data + "]";
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this.data == null?0:this.data.hashCode());
        result1 = 31 * result1 + (this.bstatus == null?0:this.bstatus.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            AppResult other = (AppResult)obj;
            if(this.data == null) {
                if(other.data != null) {
                    return false;
                }
            } else if(!this.data.equals(other.data)) {
                return false;
            }

            return this.bstatus == other.bstatus;
        }
    }
}
