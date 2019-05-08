package cn.cntrans.platform.permission.init;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.cntrans.platform.permission.annotations.PermissionOperater;
import cn.cntrans.platform.permission.annotations.PermissionResource;
import cn.cntrans.platform.permission.domain.PermissionDomain;

@Component
public class PermissionReport implements InitializingBean {
	/**
	 * 1、找RestController 2、找RestController的接口
	 * 3、找RequestMapping的注解和PermissionOperater的同时注解 4、
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Reflections reflections = new Reflections("cn.cntrans.platform.permission.provider.impl");
		Set<Class<?>> permissionResourceSet = reflections.getTypesAnnotatedWith(RestController.class);
		if (null != permissionResourceSet) {
			Set<String> permissionSet=new HashSet<String>();
			// 找到RestController初始化权限集合PermissionDomain
			PermissionDomain permissionDomain = new PermissionDomain();
			Iterator<Class<?>> it = permissionResourceSet.iterator();
			while (it.hasNext()) {
				Class<?> item = it.next();
				PermissionResource permissionResource = item.getAnnotation(PermissionResource.class);

				List<String> apiList = new ArrayList<String>();
				List<String> urlList = new ArrayList<String>();
				if (null == permissionResource) {
					// 改所有API放行
					Class<?>[] apis = item.getInterfaces();
					for (int i = 0; i < apis.length; i++) {
						RequestMapping requestMappingApi = apis[i].getAnnotation(RequestMapping.class);
						if (null != requestMappingApi) {
							String[] apiUrls = requestMappingApi.value();
							for (int m = 0; m < apiUrls.length; m++) {
								if (!apiUrls[m].startsWith("/")) {
									apiUrls[m] = "/" + apiUrls[m];
								}
								if (apiUrls[m].endsWith("/")) {
									apiUrls[m] = apiUrls[m].substring(0, apiUrls[m].length());
								}
								apiList.add(apiUrls[m]);
							}
						} else {
							apiList.add("/");
						}
						Method[] apiMethods = apis[i].getMethods();
						for (int j = 0; j < apiMethods.length; j++) {
							RequestMapping requestMappingMethod = apiMethods[j].getAnnotation(RequestMapping.class);
							if (null != requestMappingMethod) {
								String methodUrl = null;
								String[] methoduUrls = requestMappingMethod.value();
								RequestMethod[] methods = requestMappingMethod.method();
								for (int m = 0; m < methoduUrls.length; m++) {
									for (int n = 0; n < methods.length; n++) {
										if (!methoduUrls[m].startsWith("/")) {
											methoduUrls[m] = "/" + methoduUrls[m];
										}
										if (methoduUrls[m].endsWith("/")) {
											methoduUrls[m] = methoduUrls[m].substring(0, methoduUrls[m].length());
										}
										for (int p = 0; p < apiList.size(); p++) {
											methodUrl = methods[n].name() + "$" + apiList.get(p) + methoduUrls[m];
											urlList.add(methodUrl);
										}
									}
								}
							}
						}
					}
				} 
				else {
					Method[] mulMethods = item.getMethods();
					for (int i = 0; i < mulMethods.length; i++) {
						PermissionOperater permissionOperater = mulMethods[i].getAnnotation(PermissionOperater.class);
						if(null==permissionOperater) {
							// 递归找到所有的父接口
							Class<?>[] permissionApis = item.getInterfaces();
							for (int j = 0; j < permissionApis.length; j++) {
								Class<?> permissionApi = permissionApis[j];
								Method[] permissionApiMethods = permissionApi.getMethods();
								for (int m = 0; m < permissionApiMethods.length; m++) {
									Method permissionApiMethod = permissionApiMethods[m];
									if (mulMethods[i].getName().equals(permissionApiMethod.getName())) {
										Class<?>[] permissionApiMethodTypes = permissionApiMethod.getParameterTypes();
										Class<?>[] mulMethodsTypes = mulMethods[i].getParameterTypes();
										if (permissionApiMethodTypes.length == mulMethodsTypes.length) {
											for (int k = 0; k < permissionApiMethodTypes.length; k++) {
												if (permissionApiMethodTypes[i].isAssignableFrom(mulMethodsTypes[i])) {
													
												}
											}
										}

									}
								}

							}	
						}
						

					}

				}
				permissionSet.addAll(new HashSet<String>(urlList));
				
				
				
				/*
				 * Method[] methods = item.getMethods(); for (int i = 0; i < methods.length;
				 * i++) { Method method = methods[i]; PermissionOperater permissionOperater =
				 * method.getAnnotation(PermissionOperater.class); if (null !=
				 * permissionOperater) {
				 * 
				 * } else {
				 * 
				 * } }
				 */
			}
			permissionDomain.setWithoutPermissions(permissionSet);
			System.err.println(permissionDomain);
		}

	}

}
