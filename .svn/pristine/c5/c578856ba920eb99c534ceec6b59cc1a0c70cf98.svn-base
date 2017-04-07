package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.Advert;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fang.fangshop.redisutil.RedisCacheManager;
import com.fang.fangshop.dao.IAdvertDao;
import com.fang.fangshop.services.IAdvertService;

@Service("advertService")
public class AdvertServiceImpl extends ServicesManager<Advert, IAdvertDao> implements IAdvertService {

	@Autowired
	private RedisCacheManager redisCacheManager;
    
	@Resource(name="advertDao")
	@Override
	protected void setDao(IAdvertDao dao) {
		this.dao = dao;
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public PageModel selectPageList(Advert t) {
//		Jedis jedis = null;
//		RedisCachePool pool = null;
//
//		try {
//			pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//		    jedis = pool.getResource();
//		    Transaction transaction = jedis.multi();
//			RedisDao redisDao = new RedisDao(transaction);
//			List<Advert> adverts = null;
//			Set<String> sortKey = null;
//			List<Object> results = new ArrayList();
//
//			String[] keys = genKeys(t);
//			Integer start = t.getOffset();
//			Integer end = start + t.getPageSize() -1;
//			if(keys == null)
//			{
//				return new PageModel();
//			}
//			if (keys.length>1) {
//				String id = redisDao.zinterstore("advert", new ZParams(), keys,60);
//				// 获取健的集合
//				redisDao.zrevrange("advert",id,start,end);
//				redisDao.del("advert", id);
//				results = transaction.exec();
//				sortKey = (Set<String>)results.get(2);
//			} else {
//				// 获取健的集合
//				redisDao.zrevrange("advert", "id", start,end);
//				results = transaction.exec();
//				sortKey = (Set<String>)results.get(1);
//			}
//		    // 获取分页数据
//		    Pipeline pipeline = jedis.pipelined();
//			if (sortKey != null) {
//				adverts = (List<Advert>)RedisDao.getListBeanByMap(sortKey, Advert.class,pipeline);
//			}
//			// 返回数据
//			PageModel pageModel = new PageModel();
//			pageModel.setList(adverts);
//			pageModel.setTotal(((Long)results.get(0)).intValue());
//			return pageModel;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			pool.returnResource(jedis);
//		}
//		return super.selectPageList(t);
//	}
//
//	@Override
//	public Advert selectById(String id) {
//		Jedis jedis = null;
//		RedisCachePool pool = null;
//		try {
//			pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//		    jedis = pool.getResource();
//			Pipeline pipeline = jedis.pipelined();
//
//			Set<String> sortKey = new HashSet<String>();
//			sortKey.add("advert:" + id);
//			@SuppressWarnings("unchecked")
//			List<Advert> adverts = (List<Advert>)RedisDao.getListBeanByMap(sortKey, Advert.class,pipeline);
//			if(adverts != null)
//			{
//				return adverts.get(0);
//			}
//			else
//			{
//				return new Advert();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			pool.returnResource(jedis);
//		}
//		return null;
//	}
//	/**
//	 * 组装KEYS
//	 * @param user
//	 * @return
//	 */
//	private String[] genKeys(Advert advert) {
//		RedisCachePool pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//	    Jedis jedis = pool.getResource();
//		RedisDao redisDao = new RedisDao(jedis);
//
//		String[] string = null;
//		StringBuilder sb = new StringBuilder();
//
//		try {
//
//			//对于模糊查询，先做并集在做交集
//			if(!StringUtils.isBlank(advert.getTitle())){
//			    Set<String>	set = redisDao.keys("advert:title:*" + StringUtil.converterToFirstSpell(advert.getTitle()) + "*");
//			    if(set.size()>0)
//			    {
//				    String[] strings = set.toArray(new String[set.size()]);
//					String id = redisDao.sunionstore("advert", strings, 600);
//					sb.append("," + "advert:sort:" + id);
//			    }
//			    else
//			    {
//			    	return null;
//			    }
//			}
//			if (!StringUtils.isBlank(advert.getCode())) {
//				sb.append("," + "advert:code:" + advert.getCode());
//			}
//			sb.append("," + "advert:sort:id");
//			if (null != sb.toString()) {
//				// 去除第一个逗号
//				String replaceString = sb.toString().replaceFirst(",", "");
//				string = replaceString.split(",");
//			}
//		}
//		finally {
//			pool.returnResource(jedis);
//		}
//		return string;
//	}

}
