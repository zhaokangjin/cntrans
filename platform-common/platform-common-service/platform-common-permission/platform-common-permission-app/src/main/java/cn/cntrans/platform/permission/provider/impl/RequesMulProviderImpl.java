package cn.cntrans.platform.permission.provider.impl;

import org.springframework.web.bind.annotation.RestController;

import cn.cntrans.platform.permission.annotations.PermissionOperater;
import cn.cntrans.platform.permission.annotations.PermissionResource;
import cn.cntrans.platform.permission.provider.RequesMulProvider;

@RestController
@PermissionResource
public class RequesMulProviderImpl implements RequesMulProvider {
	@Override
	public int test1() {
		return 0;
	}
	@PermissionOperater
	@Override
	public int test2() {
		return 0;
	}
}
