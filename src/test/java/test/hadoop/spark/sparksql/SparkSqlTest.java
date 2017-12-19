package test.hadoop.spark.sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * @description
 * @author lianglong
 */
public class SparkSqlTest {

	public static void main(String[] args) {

		String logFile = "hdfs://192.168.10.107:9000/user/hdfs/flume/";
//		String logFile = "C:\\Users\\Administrator\\Desktop\\test.txt";
//		SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("spark://192.168.10.107:7077");
//		SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("local[4]");
		JavaSparkContext sc = new JavaSparkContext("local","Simple Application","SPARK_HOME", JavaSparkContext.jarOfClass(SparkSqlTest.class));
//		sc.addJar("hdfs://192.168.10.107:9000/user/spark/test.jar");
		JavaRDD<String> logData = sc.textFile(logFile).cache();
		long numAs = logData.filter(new Function<String, Boolean>() {
			private static final long serialVersionUID = 1L;

			public Boolean call(String s) {
				return s.contains("1");
			}
		}).count();
		long numBs = logData.filter(new Function<String, Boolean>() {
			private static final long serialVersionUID = 1L;

			public Boolean call(String s) {
				return s.contains("b");
			}
		}).count();
		System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
	}

}
