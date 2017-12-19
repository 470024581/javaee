package test.hadoop.spark.sparksql;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import com.util.Test;

import scala.Tuple2;


public final class JavaFlumeEventCount {
  private JavaFlumeEventCount() {
  }

  public static void main(String[] args) throws Exception {
	  JavaSparkContext sc = new JavaSparkContext("local[4]","Simple Application","SPARK_HOME", JavaSparkContext.jarOfClass(JavaFlumeEventCount.class));
	  JavaRDD<String> textFile = sc.textFile("hdfs://192.168.10.107:9000/user/hdfs/flume/2016-04-11.1460382626368");
	  JavaRDD<String> words = textFile.flatMap(new FlatMapFunction<String, String>() {
	    public Iterable<String> call(String s) { return Arrays.asList(s.split(" ")); }
	  });
	  JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
	    public Tuple2<String, Integer> call(String s) { return new Tuple2<String, Integer>(s, 1); }
	  });
	  JavaPairRDD<String, Integer> counts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
	    public Integer call(Integer a, Integer b) { return a + b; }
	  });
	  counts.saveAsTextFile("hdfs://192.168.10.107:9000/user/hdfs/flume/");
  }
}
