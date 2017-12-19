package test.hadoop.spark.streaming;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Serializable;
import scala.Tuple2;

public class IpStats implements Serializable {

     private static final long serialVersionUID = 8533489548835413763L;
     private static final Log LOG = LogFactory.getLog(IpStats.class);
     private static final Pattern SPACE = Pattern.compile(" ");
    
     public IpStats() {
    	 
     }
    
     @SuppressWarnings("serial")
     public void stat(String[] args) {
          JavaSparkContext ctx = new JavaSparkContext("local[4]", "IpStats", System.getenv("SPARK_HOME"), JavaSparkContext.jarOfClass(IpStats.class));
          JavaRDD<String> lines = ctx.textFile("hdfs://192.168.10.107:9000/user/hdfs/flume/2016-04-11.1460382626368", 1);

          // splits and extracts ip address filed
          JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
               @Override
               public Iterable<String> call(String s) {
                    // 121.205.198.92 - - [21/Feb/2014:00:00:07 +0800] "GET /archives/417.html HTTP/1.1" 200 11465 "http://shiyanjun.cn/archives/417.html/" "Mozilla/5.0 (Windows NT 5.1; rv:11.0) Gecko/20100101 Firefox/11.0"
                    // ip address
            	   String[] strs = s.split(" ");
            	   
                    return Arrays.asList(strs);
               }
          });

          // map
          JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
               @Override
               public Tuple2<String, Integer> call(String s) {
                    return new Tuple2<String, Integer>(s, 1);
               }
          });

          // reduce
          JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
               @Override
               public Integer call(Integer i1, Integer i2) {
                    return i1 + i2;
               }
          });
         
          List<Tuple2<String, Integer>> output = counts.collect();
         
          // sort statistics result by value
//          Collections.sort(output, new Comparator<Tuple2<String, Integer>>() {
//               @Override
//               public int compare(Tuple2<String, Integer> t1, Tuple2<String, Integer> t2) {
//                    if(t1._2 < t2._2) {
//                         return 1;
//                    } else if(t1._2 > t2._2) {
//                         return -1;
//                    }
//                    return 0;
//               }
//          });
         
          writeTo(args, output);
     }
    
     private void writeTo(String[] args, List<Tuple2<String, Integer>> output) {
          for (Tuple2<?, ?> tuple : output) {
//               Country country = lookupService.getCountry((String) tuple._1);
//               LOG.info("[" + country.getCode() + "] " + tuple._1 + "\t" + tuple._2);
        	  LOG.info("[" + "] " + tuple._1 + "\t" + tuple._2);
          }
     }
    
     public static void main(String[] args) {
          // ./bin/run-my-java-example org.shirdrn.spark.job.IpStats spark://m1:7077 hdfs://m1:9000/user/shirdrn/wwwlog20140222.log /home/shirdrn/cloud/programs/spark-0.9.0-incubating-bin-hadoop1/java-examples/GeoIP_DATABASE.dat
//          if (args.length < 3) {
//               System.err.println("Usage: IpStats <master> <inFile> <GeoIPFile>");
//               System.err.println("    Example: org.shirdrn.spark.job.IpStats spark://m1:7077 hdfs://m1:9000/user/shirdrn/wwwlog20140222.log /home/shirdrn/cloud/programs/spark-0.9.0-incubating-bin-hadoop1/java-examples/GeoIP_DATABASE.dat");
//               System.exit(1);
//          }
         
          IpStats stats = new IpStats();
          stats.stat(args);
         
          System.exit(0);

     }

}
