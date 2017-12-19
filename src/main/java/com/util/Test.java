package com.util;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * @description
 * @author lianglong
 */
public class Test {

	public static void main(String[] args) {

		String logFile = "hdfs://192.168.61.128:9000/user/hdfs/flume/2016-04-11.1460382626368";
//		String logFile = "C:\\Users\\Administrator\\Desktop\\test.txt";
//		SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("spark://192.168.61.128:7077");
//		SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("master1");
		JavaSparkContext sc = new JavaSparkContext("spark://192.168.61.128:7077","Simple Application","SPARK_HOME", JavaSparkContext.jarOfClass(Test.class));
		sc.addJar("hdfs://192.168.61.128:9000/user/spark/test.jar");
		JavaRDD<String> logData = sc.textFile(logFile).cache();
		long numAs = logData.filter(new Function<String, Boolean>() {
			public Boolean call(String s) {
				return s.contains("a");
			}
		}).count();
		long numBs = logData.filter(new Function<String, Boolean>() {
			public Boolean call(String s) {
				return s.contains("b");
			}
		}).count();
		System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
	}

}
