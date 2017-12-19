package test.hadoop;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import test.hadoop.hive.HiveJdbcTest;
import test.hadoop.spark.sparksql.SparkSqlTest;

import com.util.JsonUtil;

public class DemoTest {

	private static final String HDFS = "hdfs://192.168.10.107:9000/";
	
	private static final  String HDFS_SPARK = "hdfs://192.168.10.107:9000/user/hdfs/spark/";
	
	private static final String HDFS_LOG = "hdfs://192.168.10.107:9000/user/hdfs/flume/";

	private static Configuration conf = new JobConf();

	public static void main(String[] args) throws IOException {
//		ls("/tmp");
		try {
			spark();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		hiveLoad();
//		upload();
	}

	public static void ls(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
		FileStatus[] list = fs.listStatus(path);
		System.out.println("ls: " + folder);
		System.out.println("==========================================================");
		for (FileStatus f : list) {
			System.out.printf("name: %s, folder: %s, size: %d\n", f.getPath(), f.isDir(), f.getLen());
		}
		System.out.println("==========================================================");
		fs.close();
	}
	
	public static void upload(){
		try {
			FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
			Path dst = new Path("/user/hdfs/spark/1.txt");
			FSDataOutputStream out = fs.create(dst);
//			String str2 = "5,5,5";
//			String str1 = "6,6,6";
//			out.write(str1.getBytes(), 0, str1.getBytes().length);
//			out.write(str2.getBytes(), 0, str2.getBytes().length);
			out.writeBytes("5,5,5");
			out.writeBytes("\n");
			out.writeBytes("6,6,6");
			out.writeBytes("\n");
			out.writeBytes("7,7,7");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void spark() throws Exception {
		System.out.println("startTime:"+new Date().toGMTString());
		
		JavaSparkContext sc = new JavaSparkContext("local", "Simple Application", "SPARK_HOME", JavaSparkContext.jarOfClass(SparkSqlTest.class));
		JavaRDD<String> logData = sc.textFile(HDFS_LOG).cache();
		JavaRDD<String> data = logData.map(new Function<String, String>() {
			@Override
			public String call(String s) throws Exception {
				String comma = ",";
				s = s.replace("@", "");
				s = s.replace("\\", "\\\\");
				Source source = JsonUtil.toObject(s, Source.class);
				StringBuilder sb = new StringBuilder();
				if(source != null){
					sb.append(source.getVersion())
					.append(comma)
					.append(source.getRemote_addr())
					.append(comma)
					.append(source.getUrl())
					.append(comma)
					.append(source.getDomain())
					.append(comma)
					.append(source.getHost());
				}
				return sb.toString();
			}
		});
		List<String> list = data.collect();
		System.out.println("midTime"+new Date().toGMTString());

		
		System.out.println(list.size());
		FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
		Path dst = new Path("/user/hdfs/hive/t4/1.txt");
		final FSDataOutputStream out = fs.create(dst);
		if(list != null && list.size() > 0){
			for(String str : list){
				out.writeBytes(str);
				out.writeBytes("\n");
			}
			
		}
		
		System.out.println("endTime:"+new Date().toGMTString());
//		System.out.println(data.toString());
//		data.saveAsTextFile(HDFS_SPARK);
	}

	public static void hiveLoad() {
		try {
			Connection con = HiveJdbcTest.getConnection();
			Statement stmt = con.createStatement();
			String sql = "load data local inpath '" + HDFS_SPARK + "12.txt" + "' into table t2";
			System.out.println("Running:" + sql);
			ResultSet res = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}