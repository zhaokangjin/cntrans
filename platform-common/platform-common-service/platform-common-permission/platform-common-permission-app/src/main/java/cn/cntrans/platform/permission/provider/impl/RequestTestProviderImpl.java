package cn.cntrans.platform.permission.provider.impl;

import org.springframework.web.bind.annotation.RestController;

import cn.cntrans.platform.permission.annotations.PermissionOperater;
import cn.cntrans.platform.permission.annotations.PermissionResource;
import cn.cntrans.platform.permission.provider.RequestTestProvider;
@RestController
@PermissionResource
public class RequestTestProviderImpl implements RequestTestProvider {

	@Override
	@PermissionOperater
	public int saveTest(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
