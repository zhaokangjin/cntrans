package cn.cntrans.platform.permission.domain;

import java.util.Set;

public class PermissionDomain {
	private Set<String> withoutPermissions;
	private Set<String> requriePermissions;

	public Set<String> getWithoutPermissions() {
		return withoutPermissions;
	}

	public void setWithoutPermissions(Set<String> withoutPermissions) {
		this.withoutPermissions = withoutPermissions;
	}

	public Set<String> getRequriePermissions() {
		return requriePermissions;
	}

	public void setRequriePermissions(Set<String> requriePermissions) {
		this.requriePermissions = requriePermissions;
	}

}
