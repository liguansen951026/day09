package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_major_day")
public class Major implements Serializable {
    @Id
    private Integer mdid;

    private String mdname;

    private static final long serialVersionUID = 1L;

    
	@Override
	public String toString() {
		return "Major [mdid=" + mdid + ", mdname=" + mdname + "]";
	}
	public Integer getMdid() {
		return mdid;
	}
	public void setMdid(Integer mdid) {
		this.mdid = mdid;
	}
	public String getMdname() {
		return mdname;
	}
	public void setMdname(String mdname) {
		this.mdname = mdname;
	}
	
    
	
}