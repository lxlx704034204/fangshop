package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.News;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fang.fangshop.redisutil.RedisCacheManager;
import com.fang.fangshop.dao.INewsDao;
import com.fang.fangshop.services.INewsService;

@Service("newsService")
public class NewsServiceImpl extends ServicesManager<News, INewsDao> implements INewsService {
	@Autowired
	private RedisCacheManager redisCacheManager;
    
	@Resource(name="newsDao")
	@Override
	protected void setDao(INewsDao dao) {
		this.dao = dao;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public PageModel selectPageList(News t) {
//		Jedis jedis = null;
//		RedisCachePool pool = null;
//
//		try {
//			pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//		    jedis = pool.getResource();
//		    Transaction transaction = jedis.multi();
//			RedisDao redisDao = new RedisDao(transaction);
//			List<News> news = null;
//			Set<String> sortKey = null;
//
//			String[] keys = genKeys(t);
//			Integer start = t.getOffset();
//			Integer end = start + t.getPageSize() -1;
//			if(keys == null)
//			{
//				return new PageModel();
//			}
//			if (!StringUtils.isBlank(keys[1])) {
//				String id = redisDao.zinterstore("news", new ZParams(), keys,60);
//				// 获取健的集合
//				redisDao.zrevrange("news",id,start,end);
//				redisDao.del("news", id);
//			} else {
//				// 获取健的集合
//				redisDao.zrevrange("news", "id", start,end);
//			}
//		    List<Object> results = transaction.exec();
//		    sortKey = (Set<String>)results.get(1);
//
//		    // 获取分页数据
//		    Pipeline pipeline = jedis.pipelined();
//			if (sortKey != null) {
//				news = (List<News>)RedisDao.getListBeanByMap(sortKey, News.class,pipeline);
//			}
//			// 返回数据
//			PageModel pageModel = new PageModel();
//			pageModel.setList(news);
//			pageModel.setTotal(((Long)results.get(0)).intValue());
//			return pageModel;
//		} catch (Exception e) {
//			e.printStackTrace();
//			// 获取数据库数据
//			return super.selectPageList(t);
//		} finally {
//			pool.returnResource(jedis);
//		}
//	}
//
//	@Override
//	public News selectById(String id) {
//		Jedis jedis = null;
//		RedisCachePool pool = null;
//		try {
//			pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//		    jedis = pool.getResource();
//			Pipeline pipeline = jedis.pipelined();
//
//			Set<String> sortKey = new HashSet<String>();
//			sortKey.add("news:" + id);
//			List<News> news = (List<News>)RedisDao.getListBeanByMap(sortKey, News.class,pipeline);
//			if(news != null)
//			{
//				return news.get(0);
//			}
//			else
//			{
//				return new News();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return super.selectById(id);
//		} finally {
//			pool.returnResource(jedis);
//		}
//	}
//	/**
//	 * 组装KEYS
//	 * @param user
//	 * @return
//	 */
//	private String[] genKeys(News news) {
//		RedisCachePool pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//	    Jedis jedis = pool.getResource();
//		RedisDao redisDao = new RedisDao(jedis);
//
//		String[] string = null;
//		StringBuilder sb = new StringBuilder();
//
//		try {
//			if (!StringUtils.isBlank(news.getType())) {
//				sb.append("," + "news:type:" + news.getType());
//			}
//			//对于模糊查询，先做并集在做交集
//			if(!StringUtils.isBlank(news.getTitle())){
//			    Set<String>	set = redisDao.keys("news:title:*" + StringUtil.converterToFirstSpell(news.getTitle()) + "*");
//			    if(set.size()>0)
//			    {
//				    String[] strings = set.toArray(new String[set.size()]);
//					String id = redisDao.sunionstore("news", strings, 600);
//					sb.append("," + "news:sort:" + id);
//			    }
//			    else
//			    {
//			    	return null;
//			    }
//			}
//			if (!StringUtils.isBlank(news.getStatus())) {
//				sb.append("," + "news:status:" + news.getStatus());
//			}
//			sb.append("," + "news:sort:id");
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
