package com.fang.fangshop.core.system.been;

import com.fang.fangshop.core.been.SystemSetting;
import com.fang.fangshop.core.cache.ICacheProvider;
import com.fang.fangshop.core.cache.SimpleCacheProvider;
import org.apache.commons.lang.StringUtils;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Properties;


/**
 * 系统管理类. 1、负责管理system.properties的东东 2、负责缓存管理
 * 
 * @author
 */
public class SystemManager {
	private static Properties p = new Properties();
	private static  ICacheProvider cacheProvider = new SimpleCacheProvider();
	private static SystemManager instance;
	private SystemSetting systemSetting;// 系统设置

	@PostConstruct
	public void afterPropertiesSet() {
		instance = this;
	}

	public static SystemManager getInstance() {
		return instance;
	}

	static {
		init();
	}

	private static void init() {
	}

	// 系统设置
	public SystemSetting getSystemSetting() {
		return getCacheObject("systemSetting");
	}

	public void setSystemSetting(SystemSetting systemSetting) {
		putCacheObject("systemSetting", systemSetting);
	}

	public void setCacheProvider(ICacheProvider cacheProvider) {
		SystemManager.cacheProvider = cacheProvider;
	}

	private static String buildKey(String key) {
		return "SystemManager." + StringUtils.trimToEmpty(key);
	}

	private static void putCacheObject(String key, Serializable cacheObject) {
		String key1 = buildKey(key);
		if (cacheObject == null) {
			cacheProvider.remove(key1);
		} else {
			cacheProvider.put(key1, cacheObject);
		}
	}

	private static <T extends Serializable> T getCacheObject(String key) {
		return (T) cacheProvider.get(buildKey(key));
	}
}
