package com.kafka.producer.partition;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;
 
public class SimplePartitioner implements Partitioner {
	
    public SimplePartitioner (VerifiableProperties props) {
 
    }
    /**
     * 
     * 分区算法
     * @param key 消息的key
     * @param a_numPartitions 分区数
     */
    public int partition(Object key, int a_numPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
           partition = Integer.parseInt( stringKey.substring(offset+1)) % a_numPartitions;
        }
       return partition;
  }
 
}
