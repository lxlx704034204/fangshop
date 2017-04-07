package com.fang.fangshop.core.cache;

import java.io.Serializable;

/**
 * 缓存接口
 * @author wangyantao
 *
 */
public interface ICacheProvider {
	/**
	 * 放入缓存
	 * @param key
	 * @param serializable
	 */
    public void put(String key, Serializable serializable);
    /**
     * 从缓存中去除数据
     * @param key
     * @return
     */
    public Serializable get(String key);
    /**
     * 清除缓存中指定的值
     * @param key
     */
    public void remove(String key);
    /**
     * 清除缓存中的所有值
     */
    public void clear();
}
