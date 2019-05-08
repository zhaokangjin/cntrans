package cn.cntrans.platform.permission.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value= {"/test"})
public interface RequestTestProvider {
	@RequestMapping(value= {"/save"},method=RequestMethod.POST)
	public int saveTest(String id);
}
