package com.fang.fangshop.redisutil;

import com.alibaba.fastjson.JSON;
import com.fang.fangshop.core.cache.BeanField;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.cache.RedisQuery;
import com.fang.fangshop.core.cache.RedisQueryByScope;
import com.fang.fangshop.core.common.EntityUtils;
import com.fang.fangshop.core.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.*;

import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author wangyantao
 *
 */
@Repository(value = "redisDao")
public class RedisDao {
	@Autowired
	private RedisCacheManager redisCacheManager;
	// 分隔符
	private final static String SPLIT_MARK = ":";
	// 排序key里面的标记位
	private final static String SORT = "sort";
	// 主键key里面的标记位
	private final static String INDEX = "index";
	// list格式存放log的sql
	public final static String LOG = "log";
	public final static String PUB_LOG = "publog";

	private Jedis jedis;
	private Transaction transaction;
	private Pipeline pipeline;

	/**
	 *获取连接池
	 */
	public void setJedisPool(RedisDataBaseType redisDataBaseType,RedisExecuteType redisExecuteType) {
		 RedisCachePool jedisPool = redisCacheManager.getRedisPoolMap().get(redisDataBaseType.toString());
		 switch (redisExecuteType)
		 {
			 case Jedis:
			 	jedis = jedisPool.getResource();
			 	break;
			 case Transaction:
			 	transaction = jedisPool.getResource().multi();
			 	break;
			 case Pipeline:
			 	pipeline = jedisPool.getResource().pipelined();
			 	break;
			 default:
			 	jedis = jedisPool.getResource();
			 	break;
		 }
	}
	public RedisDao(){}
	/**
	 * redis事物一旦开启之后，所有的命令都会存放都一个队里里面，不会立即执行。
	 */
	public RedisDao(Transaction transaction) {
		this.transaction = transaction;
	}

	/**
	 * 某些查询方法，用不到事物。
	 */
	public RedisDao(Jedis jedis) {
		this.jedis = jedis;
		pipeline = jedis.pipelined();
	}

	/**
	 * 管道+事物效率等于Transaction，可以用到管道
	 */
	public RedisDao(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	/****************************************************server*******************************************************/
	/**
	 * @Description比较key存储的value 和传入的value是否相等
	 * @param key
	 * @return:Boolean
	 */
	public Boolean existValueByKey(String key, String value) {
		return jedis.get(key) == value ? true : false;
	}
	/**
	 * 判断是否存在指定的键
	 * @param key
	 * @return
	 */
	public boolean existKey(String key){
		return jedis.exists(key);
	}

	/**
	 * @Description:模糊查询key值
	 * @param pattern
	 * @return:Set<String>
	 */
	public Set<String> keys(String pattern) {
		return jedis.keys(pattern);
	}

	/**
	 * @Description: 监听必须在开启事物之前，执行watch命令
	 * @param keys
	 * @return:void
	 */
	public void watch(String... keys) {
		jedis.watch(keys);
	}

	/**
	 * @Description:清空redis库所有缓存数据
	 * @return:void
	 */
	public void flushDB() {
		jedis.flushDB();
	}

	/*****************************************************string******************************************************/
	/**
	 * @Description:根据key返回值
	 * @param key
	 * @return:String
	 */
	public String get(String key) {
		return jedis.get(key);
	}

	/**
	 * 通过jedis设置
	 * @param key
	 * @param value
	 */
	public void set(String key,String value)
	{
		jedis.set(key,value);
	}
	/**
	 * @Description:set string类型
	 * @param key
	 * @param value
	 */
	public void setByTransaction(String key, String value) {
		transaction.set(key, value);
	}
	/**
	 * 删除健
	 * @return
	 */
	public void del(String key) {
		jedis.del(key);
	}

	/**
	 * 删除健
	 * @return
	 */
	public void delByTransaction(String key) {
		transaction.del(key);
	}
	/**
	 * @Description:根据key的set集合，返回多个key对应的stringList。
	 * @param sortKey
	 * @return:List<String>
	 */
	public List<String> getListString(Set<String> sortKey) {
		List<String> list = new ArrayList<String>();
		for (String key : sortKey) {
			list.add(jedis.get(key));
		}
		return list;
	}
	/******************************************************list******************************************************/
	/**
	 * @Description: 存放list类型
	 * @param key
	 * @param value
	 */
	public void lpush(String key, String value) {
		jedis.lpush(key, value);
	}

	/**
	 * @Description: 存放list类型
	 * @param key
	 * @param value
	 */
	public void lpushByTransaction(String key, String value) {
		transaction.lpush(key, value);
	}

	/*****************************************************hash**********************************************************/
	/**
	 * hash操作
	 */
	public void hmset(String key, Map<String, String> map) {
		jedis.hmset(key, map);
	}
	/**
	 * hash操作
	 *
	 */
	public void hmsetByTransaction(String key, Map<String, String> map) {
		transaction.hmset(key, map);
	}

	/**
	 * @Description: 删除hash类型的数据
	 * @param key
	 */
	public void hdel(String key, String field) {
		jedis.hdel(key, field);
	}

	/**
	 * @Description: 删除hash类型的数据
	 * @param key
	 */
	public void hdelByTransaction(String key, String field) {
		transaction.hdel(key, field);
	}

	/*****************************************************set*********************************************************/
	/**
	 * @Description: 存放set类型
	 * @param key
	 * @param value
	 */
	public void sadd(String key, String value) {
		jedis.sadd(key, value);
	}
	/**
	 * @Description: 存放set类型
	 * @param key
	 * @param value
	 */
	public void saddByTransaction(String key, String value) {
		transaction.sadd(key, value);
	}

	/**
	 * @Description:根据key值返回set集合
	 * @param key
	 * @return:Set<String>
	 */
	public Set<String> smembers(String key) {
		return jedis.smembers(key);
	}
	/**
	 * @Description:根据多个key值返回交集的id
	 * @param key
	 * @return:Set<String>
	 */
	public Set<String> sinter(String... key) {
		return jedis.sinter(key);
	}
	/**
	 * @Description:根据多个key值 返回并集的id
	 * @param key
	 * @return:Set<String>
	 */
	public Set<String> sunion(String... key) {
		return jedis.sunion(key);
	}
	/**
	 * @Description: 删除set类型数据
	 * @param key
	 */
	public void srem(String key, String member) {
		jedis.srem(key, member);
	}
	/**
	 * @Description: 删除set类型数据
	 * @param key
	 */
	public void sremByTransaction(String key, String member) {
		transaction.srem(key, member);
	}
	/*************************************************sortset***********************************************************/
	/**
	 * @Description: 存放sortset类型
	 * @param key
	 * @param score
	 * @param member
	 */
	public void zadd(String key, double score, String member) {
		jedis.zadd(key, score, member);
	}

	/**
	 * @Description: 存放sortset类型
	 * @param key
	 * @param score
	 * @param member
	 */
	public void zaddByTransaction(String key, double score, String member) {
		transaction.zadd(key, score, member);
	}

	/**
	 * @Description: 返回有序集 key 中，指定区间内的成员。 按照从小到大排序
	 * @param key
	 *            key值 Note:sort:noteId 0 -1
	 * @param start
	 *            初始位置
	 * @param end
	 *            结束位置
	 * @return:Set<String>
	 */
	public Set<String> getRangeSortSet(String key, int start, int end) {
		return jedis.zrange(key, start, end);
	}

	/**
	 * @Description: 返回有序集 key 中，指定区间内的成员。 按照从大到小排序
	 * @see: 例如用来插入数据时候获取主键的id
	 * @param key
	 *            key值 Note:sort:noteId 0 0
	 * @param start
	 *            初始位置
	 * @param end
	 *            结束位置
	 * @return:Set<String>
	 */
	public Set<String> getRevrangeSortSet(String key, int start, int end) {
		return jedis.zrevrange(key, start, end);
	}

	/**
	 * @Description: 删除sortset类型的数据
	 * @param key
	 * @param member
	 */
	public void zrem(String key, String member) {
		jedis.zrem(key, member);
	}
	/**
	 * @Description: 删除sortset类型的数据
	 * @param key
	 * @param member
	 */
	public void delSortSet(String key, String member) {
		transaction.zrem(key, member);
	}

	/**
	 * 排名分页
	 *
	 */
	public Set<String> zrangeByScore(String key, String column, String min, String max, Integer start,
			Integer end) {
		Set<String> set = jedis.zrangeByScore(key, min, max, start, end);
		return set;
	}
	/**
	 * 获得健集合
	 */
	public Set<String> zrangeByScore(String key, String min, String max) {
		Set<String> set = jedis.zrangeByScore(key, min, max);
		return set;
	}
	/**
	 * 交集
	 */
	public String zinterstore(String key, ZParams params, String[] keys, int seconds) {
		String id = UUID.randomUUID().toString();
		transaction.zinterstore(key+id, params, keys);
		//transaction.expire(tableName + SPLIT_MARK + SORT + SPLIT_MARK + id, seconds);
		return id;
	}
	/**
	 * 集合取并集
	 * @return
	 */
	public String sunionstore(String key,String[] keys,int seconds)
	{
		String id = UUID.randomUUID().toString();
		jedis.sunionstore(key + id, keys);
		//jedis.expire(tableName + SPLIT_MARK + SORT + SPLIT_MARK + id, seconds);
		return id;
	}
	/**
	 * 取得集合总数
	 * @return
	 */
	public void zcard(String key) {
		jedis.zcard(key);
	}
	/**
	 * 取得集合总数
	 * @return
	 */
	public void zcardByTransaction(String key) {
	    transaction.zcard(key);
	}

	/**
	 * 删除集合
	 * @return
	 */
	public Integer zrem(String key, String column, String[] members) {
		Long count = jedis.zrem(key, members);
		return Integer.parseInt(count.toString());
	}

	/*********************************************pub****************************************************************/
	/**
	 * @Description:操作redis日志转换成对应的sql
	 * @return:Long
	 */
	public void log(String sql) {
		transaction.lpush(LOG, sql);
	}

	/**
	 * @Description:pub/sub模式广播sqllog
	 * @param log
	 * @return:void
	 */
	public void pubishLog(String log) {
		transaction.publish(PUB_LOG, log);
	}

	/**
	 * @Description:获取redis里面list类型的log。
	 * @see:lpop命令 返回并删除名称为key的list中的首元素。如果插入数据库失败需要再把log插入进来，调用log(sql)方法
	 * @return:String
	 */
	public static String lpopLog(Jedis jedis) {
		return jedis.lpop(LOG);
	}

	/******************************************method*************************************************************/

	/**
	 * @Description: 根据jsonKey，获取相应的json字符串，转换成实体类List
	 * @return:List<T>
	 */
	public List<?> getListBeanByJson(Set<String> sortKey, Class classs) {
		List<Object> list = new ArrayList<Object>();
		for (String key : sortKey) {
			list.add(getBean(key, classs, jedis));
		}
		return list;
	}
	/**
	 * @Description: 根据Key，获取相应的Map，转换成实体类List
	 * @return:List<T>
	 */
	public static List<?> getListBeanByMap(Set<String> sortKey, Class classs,Pipeline pipeline) {
		// 使用pipeline
		Map<String, Response<Map<String, String>>> responses = new HashMap<String, Response<Map<String, String>>>(
				sortKey.size());
		for (String key : sortKey) {
			responses.put(key,  pipeline.hgetAll(key));
		}
		pipeline.sync();
		List<Object> list = new ArrayList<Object>();
		for (String key : responses.keySet()) {
			Map<String, String> map = responses.get(key).get();
			Object object = EntityUtils.hashToObject(map, classs);
			list.add(object);
		}
		return list;
	}

	/**
	 * @Description:根据jsonKey，获取相应的json字符串，转换成实体类
	 * @param key
	 * @return:T dao层泛型的实体类
	 */
	public static Object getBean(String key, Class classs, Jedis jedis) {
		return JSON.parseObject(jedis.get(key), classs);
	}

	/**
	 * @Description:根据jsonKey，获取相应的Map，转换成实体类
	 * @param key
	 * @return:T dao层泛型的实体类
	 */
	public Object getBeanByMap(String key, Class<?> classs) {
		Map<String, String> map = jedis.hgetAll(key);
		Object object = EntityUtils.hashToObject(map, classs);
		return object;
	}

	/**
	 * @Description: 获取实体类对象list 插入到redis里面
	 * @param list
	 *            实体类集合
	 */
	public void insertListToredis(List<Object> list) throws Exception {
		if (null != list && list.size() > 0) {
			BeanField bf = getBeanField(list.get(0));
			for (Object tt : list) {
				insertSingleDataToredis(tt, bf);
			}
		}
	}

	/**
	 * @Description:插入单个实体类到redis
	 * @param t
	 *            实体类
	 * @param fieldList
	 *            实体类字段数组
	 * @param primaryKey
	 *            实体类主键的名称
	 * @param className
	 *            实体类的名称
	 */
	@SuppressWarnings("unused")
	public void insertSingleDataToredis(Object t, BeanField bf) throws Exception {
		Field[] fieldList = bf.getFieldList();
		String primaryKey = bf.getPrimaryKey();
		String className = bf.getClassName();
		// 获取主键值
		Field pvField = t.getClass().getDeclaredField(primaryKey);
		pvField.setAccessible(true);
		String primaryValue = pvField.get(t).toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, String> map = new HashMap<String, String>();
		for (Field field : fieldList) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object fieldValue = field.get(t);
			// 存放hash
			if (!field.isAnnotationPresent(RedisFieldNotCache.class)) {
				if(fieldValue instanceof Date){
					if(fieldValue != null){
						map.put(fieldName,sdf.format(fieldValue));
					} else{
						map.put(fieldName,"");
					}
				} else {
					map.put(fieldName,fieldValue == null?"":fieldValue.toString());
				}
			}
			// 去除不缓存的
			if (null != fieldValue && !field.isAnnotationPresent(RedisFieldNotCache.class)) {
				// 1、类型一k/v
				// setTable(className, primaryValue, fieldName,
				// fieldValue.toString());
				// 对有注解的进行sadd kv存储
				if (field.isAnnotationPresent(RedisQuery.class)) {
					// 2、类型二 k/v
					String key = className+ SPLIT_MARK+ fieldName + SPLIT_MARK +StringUtil.converterToFirstSpell(fieldValue.toString());
					sadd(key, primaryValue);
				}
				if(field.isAnnotationPresent(RedisQueryByScope.class)){
					String key = className+fieldName;
					double value = StringUtil.stringToScore(fieldValue.toString(), true);
					zadd(key, value, className + SPLIT_MARK + primaryValue);
				}
			}
		}
		// 1、hash
		if (map.size() >= 1) {
			hmset(className + SPLIT_MARK + primaryValue, map);
		}
		// 3、 存放映射bean key-jsonValue
		// setJSON(className, primaryValue, JSON.toJSON(t).toString());
		// 4、所有主键建立索引
		sadd(className+ SPLIT_MARK + INDEX + SPLIT_MARK + primaryKey, className+ SPLIT_MARK + primaryValue);
		// 5、按照id大小排序
		zadd(className + SPLIT_MARK + SORT + SPLIT_MARK + primaryKey, Double.parseDouble(primaryValue), className + SPLIT_MARK + primaryValue);
	}

	/**
	 * @Description: 从redis删除条数据
	 * @param list
	 * @throws Exception
	 * @return:void
	 */
	public void delDataListFromRedis(List<Object> list) throws Exception {
		if (null != list && list.size() > 0) {
			// 例如 primaryKey=noteId className=Note
			BeanField bf = getBeanField(list.get(0));
			for (Object tt : list) {
				delSingleDataFromRedis(tt, bf);
			}
		}
	}

	/**
	 * @Description: 从redis里面删除某一条数据
	 * @throws Exception
	 * @return:void
	 */
	public void delSingleDataFromRedis(Object t, BeanField bf) throws Exception {
		Field[] fieldList = bf.getFieldList();
		String primaryKey = bf.getPrimaryKey();
		String className = bf.getClassName();

		// 获取主键值
		Field pvField = t.getClass().getDeclaredField(primaryKey);
		pvField.setAccessible(true);
		String primaryValue = pvField.get(t).toString();
		for (Field field : fieldList) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object fieldValue = field.get(t);
			// 1、删除hash
			if (!field.isAnnotationPresent(RedisFieldNotCache.class)) {
				hdel(className + SPLIT_MARK + primaryValue, fieldName);
			}
			// 去除不缓存的
			if (null != fieldValue && !field.isAnnotationPresent(RedisFieldNotCache.class)) {
				// 1、删除类型一k/v
				// delString(className + SPLIT_MARK + primaryValue + SPLIT_MARK
				// + fieldName);
				// 对有注解的进行sadd kv存储
				if (field.isAnnotationPresent(RedisQuery.class)) {
					// 2、删除类型2
					srem(className + SPLIT_MARK + fieldName + SPLIT_MARK + StringUtil.converterToFirstSpell(fieldValue.toString()),
							className + SPLIT_MARK + primaryValue);
					// 6、删除分页数据
					// delSortSet(className + SPLIT_MARK + SORT + SPLIT_MARK +
					// fieldName, className + ":" + primaryValue);
				}
				if(field.isAnnotationPresent(RedisQueryByScope.class)){
					delSortSet(className + SPLIT_MARK + SORT + SPLIT_MARK + fieldName,
							className + ":" + primaryValue);
				}
			}
		}
		// 3、删除类型三 json格式
		// delString(className + SPLIT_MARK + primaryValue);
		// 4、删除索引
		srem(className + SPLIT_MARK + INDEX + SPLIT_MARK + primaryKey, className + SPLIT_MARK + primaryValue);
		// 5、删除某个排序
		delSortSet(className + SPLIT_MARK + SORT + SPLIT_MARK + primaryKey, className + ":" + primaryValue);
	}

	/**
	 *
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public BeanField getBeanField(Object t) throws Exception {
		// 获取主键名称
		Field pkField = t.getClass().getDeclaredField("primaryKey");
		pkField.setAccessible(true);
		String primaryKey = pkField.get(t).toString();

		// 获取类名称
		Field cnField = t.getClass().getDeclaredField("className");
		cnField.setAccessible(true);
		String className = cnField.get(t).toString();

		Field[] fieldList = t.getClass().getDeclaredFields();
		return new BeanField(primaryKey, className, fieldList);
	}

	/**
	 * @Description: 更新redis里面的某个数据
	 * @param oldObject
	 *            原来的对象
	 * @param t
	 * @param bf
	 */
	@SuppressWarnings("unused")
	public void updateSingleFromToredis(Object oldObject, Object t, BeanField bf)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field[] fieldList = bf.getFieldList();
		String primaryKey = bf.getPrimaryKey();
		String className = bf.getClassName();
		// 获取主键值
		Field pvField = t.getClass().getDeclaredField(primaryKey);
		pvField.setAccessible(true);
		String primaryValue = pvField.get(t).toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, String> map = new HashMap<String, String>();
		for (Field field : fieldList) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object fieldValue = field.get(t);
			// 存放hash
			if (!field.isAnnotationPresent(RedisFieldNotCache.class)) {
				if (fieldValue instanceof Date) {
					if (fieldValue != null) {
						map.put(fieldName, sdf.format(fieldValue));
					} else {
						map.put(fieldName, "");
					}
				} else {
					map.put(fieldName, fieldValue == null ? "" : fieldValue.toString());
				}
			}
			// 去除不缓存的
			if (null != fieldValue && !field.isAnnotationPresent(RedisFieldNotCache.class)) {
				// 1、更新类型一k/v
				// setTable(className, primaryValue, fieldName,
				// fieldValue.toString());
				// 对有注解的进行sadd kv存储
				if (field.isAnnotationPresent(RedisQuery.class)) {
					// 删除就的类型2
					srem(className + SPLIT_MARK + fieldName + SPLIT_MARK + StringUtil.converterToFirstSpell(oldObject.toString()),
							className + SPLIT_MARK + primaryValue);
					// 2、更新类型二 k/v
					sadd(className + SPLIT_MARK + fieldName + SPLIT_MARK + StringUtil.converterToFirstSpell(fieldValue.toString()), className + SPLIT_MARK + primaryValue);
				}
				if(field.isAnnotationPresent(RedisQueryByScope.class)){
					double value = StringUtil.stringToScore(fieldValue.toString(), true);
					zadd(className + SPLIT_MARK + SORT + SPLIT_MARK + fieldName, value, className + SPLIT_MARK + primaryValue);
				}
			}
		}
		// 1、hash
		if (map.size() >= 1) {
			hmset(className + SPLIT_MARK + primaryValue, map);
		}
		// 3、更新 存放映射bean key-jsonValue
		// setJSON(className, primaryValue, JSON.toJSON(t).toString());
	}
}

