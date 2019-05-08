package cn.cntrans.platform.permission.domain;

import java.util.List;

public class PermissionResourceDomain {
	private List<PermissionOperaterDomain> operaters;

	public List<PermissionOperaterDomain> getOperaters() {
		return operaters;
	}

	public void setOperaters(List<PermissionOperaterDomain> operaters) {
		this.operaters = operaters;
	}
}
