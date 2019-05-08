package cn.cntrans.platform.permission.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value= {"/mul"})
public interface RequesMulProvider {
	@RequestMapping(value= {"/test3"},method= {RequestMethod.GET,RequestMethod.POST})
	public int test1();
	@RequestMapping(value= {"/test4"},method= {RequestMethod.GET,RequestMethod.POST})
	public int test2();

}
