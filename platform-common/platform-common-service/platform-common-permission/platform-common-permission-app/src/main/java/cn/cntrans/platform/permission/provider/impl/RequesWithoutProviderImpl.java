package cn.cntrans.platform.permission.provider.impl;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.SerializationFeature;

import cn.cntrans.platform.permission.provider.RequesWithoutProvider;
@RestController
public class RequesWithoutProviderImpl implements RequesWithoutProvider {

	@Override
	public int test1() {
		return 0;
	}

	@Override
	public int test2() {
		// TODO Auto-generated method stub
		return 0;
	}

}
