 package com.crnet.mycluster;
import java.util.HashSet;
import java.util.Set;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	public static void main(String[] args) {
		// 数据库链接池配置
		JedisPoolConfig config = new JedisPoolConfig(); 
		config.setMaxTotal(100); 
		config.setMaxIdle(50); 
		config.setMinIdle(20); 
		config.setMaxWaitMillis(6 * 1000); 
		config.setTestOnBorrow(true); 
	    Boolean info=config.getLifo();
	    System.out.println(info);
		// Redis集群的节点集合
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("10.0.53.60", 7000));
		jedisClusterNodes.add(new HostAndPort("10.0.53.60", 7001));
		jedisClusterNodes.add(new HostAndPort("10.0.53.60", 7002));
		jedisClusterNodes.add(new HostAndPort("10.0.53.60", 7003));
		jedisClusterNodes.add(new HostAndPort("10.0.53.60", 7004));
		jedisClusterNodes.add(new HostAndPort("10.0.53.60", 7005));
		Boolean a=jedisClusterNodes.isEmpty();
		System.out.println(a);
		// 根据节点集创集群链接对象
		//JedisCluster jedisCluster = newJedisCluster(jedisClusterNodes);
		// 节点，超时时间，最多重定向次数，链接池
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 2000, 100,config);
		String key = "jaydar";
		String value="kazak";
		// 存数据
		jedisCluster.set(key,value);
		// 取数据
		 value= jedisCluster.get(key);
		 System.out.println(value);
		 System.out.println(jedisCluster.exists("jaydar"));
	}
}