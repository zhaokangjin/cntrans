package cn.cntrans.platform.permission.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value= {"/without"})
public interface RequesWithoutProvider {
	@RequestMapping(value= {"/test1"},method= {RequestMethod.GET,RequestMethod.POST})
	public int test1();
	@RequestMapping(value= {"/test2"},method=RequestMethod.GET)
	public int test2();
}
