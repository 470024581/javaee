package test.hadoop.hive;


import parquet.org.apache.thrift.protocol.TBinaryProtocol;
import parquet.org.apache.thrift.protocol.TProtocol;
import parquet.org.apache.thrift.transport.TSocket;

/**
 * @description 
 * @author lianglong
 */
public class HiveThriftTest {

	public static void main(String[] args) throws Exception {
		// 创建socket连接
		final TSocket socket = new TSocket("192.168.10.107", 10000);
		
		//创建协议
		final TProtocol protocol = new TBinaryProtocol(socket);
		
		// 创建client
//		final HiveClient client = new Hiveclient();
		
	}

}
