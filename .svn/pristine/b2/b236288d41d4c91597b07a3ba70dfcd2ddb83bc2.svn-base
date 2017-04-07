package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.IndexImg;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fang.fangshop.redisutil.RedisCacheManager;
import com.fang.fangshop.dao.IIdexImgDao;
import com.fang.fangshop.services.IIndexImgService;

@Service("indexImgService")
public class IndexImgServiceImpl extends ServicesManager<IndexImg, IIdexImgDao> implements IIndexImgService {

	@Autowired
	private RedisCacheManager redisCacheManager;
    
	@Resource(name="indexImgDao")
	@Override
	protected void setDao(IIdexImgDao dao) {
		this.dao = dao;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public PageModel selectPageList(IndexImg t) {
//		Jedis jedis = null;
//		RedisCachePool pool = null;
//
//		try {
//			pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//		    jedis = pool.getResource();
//		    Transaction transaction = jedis.multi();
//			RedisDao redisDao = new RedisDao(transaction);
//			List<IndexImg> indexImgs = null;
//			Set<String> sortKey = null;
//
//			String[] keys = genKeys(t);
//			Integer start = t.getOffset();
//			Integer end = start + t.getPageSize() -1;
//			if(keys == null)
//			{
//				return new PageModel();
//			}
//			if (keys.length>1) {
//				String id = redisDao.zinterstore("indeximg", new ZParams(), keys,60);
//				// 获取健的集合
//				redisDao.zrevrange("indeximg",id,start,end);
//				redisDao.del("indeximg", id);
//			} else {
//				// 获取健的集合
//				redisDao.zrevrange("indeximg", "id", start,end);
//			}
//		    List<Object> results = transaction.exec();
//		    sortKey = (Set<String>)results.get(1);
//
//		    // 获取分页数据
//		    Pipeline pipeline = jedis.pipelined();
//			if (sortKey != null) {
//				indexImgs = (List<IndexImg>)RedisDao.getListBeanByMap(sortKey, IndexImg.class,pipeline);
//			}
//			// 返回数据
//			PageModel pageModel = new PageModel();
//			pageModel.setList(indexImgs);
//			pageModel.setTotal(((Long)results.get(0)).intValue());
//			return pageModel;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			pool.returnResource(jedis);
//		}
//		return null;
//		//return super.selectPageList(t);
//	}
//
//	@Override
//	public IndexImg selectById(String id) {
//		Jedis jedis = null;
//		RedisCachePool pool = null;
//		try {
//			pool = redisCacheManager.getRedisPoolMap().get(RedisDataBaseType.defaultType.toString());
//		    jedis = pool.getResource();
//			Pipeline pipeline = jedis.pipelined();
//
//			Set<String> sortKey = new HashSet<String>();
//			sortKey.add("indeximg:" + id);
//			@SuppressWarnings("unchecked")
//			List<IndexImg> indexImgs = (List<IndexImg>)RedisDao.getListBeanByMap(sortKey, IndexImg.class,pipeline);
//			if(indexImgs != null)
//			{
//				return indexImgs.get(0);
//			}
//			else
//			{
//				return new IndexImg();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			pool.returnResource(jedis);
//		}
//		return super.selectById(id);
//	}
//	/**
//	 * 组装KEYS
//	 * @param user
//	 * @return
//	 */
//	private String[] genKeys(IndexImg indexImg) {
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
//			if(!StringUtils.isBlank(indexImg.getTitle())){
//			    Set<String>	set = redisDao.keys("indeximg:title:*" + StringUtil.converterToFirstSpell(indexImg.getTitle()) + "*");
//			    if(set.size()>0)
//			    {
//				    String[] strings = set.toArray(new String[set.size()]);
//					String id = redisDao.sunionstore("indeximg", strings, 600);
//					sb.append("," + "indeximg:" + id);
//			    }
//			    else
//			    {
//			    	return null;
//			    }
//			}
//			sb.append("," + "indeximg:sort:id");
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
