package com.fang.fangshop.core.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单缓存
 * @author wangyantao
 *
 */
public class SimpleCacheProvider implements ICacheProvider {
	private static SimpleCacheProvider instance = new SimpleCacheProvider();
	private static Map<String, Serializable> cacheContainer = new HashMap<String,Serializable>();
	
    public SimpleCacheProvider() {
		
	}
    
    public SimpleCacheProvider getInstance(){
    	return instance;
    }
	@Override
	public void put(String key, Serializable serializable) {
		cacheContainer.put(key, serializable);
	}

	@Override
	public Serializable get(String key) {
		return cacheContainer.get(key);
	}

	@Override
	public void remove(String key) {
		cacheContainer.remove(key);
	}

	@Override
	public void clear() {
		cacheContainer.clear();
	}

}
