package test.hadoop.mapreduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import com.util.JsonUtil;

/**
 * @description
 * @author lianglong
 */
public class MapReduceTest {

	/**
	 * @description
	 * @author lianglong
	 */
	public class UserLogMap extends MapReduceBase implements Mapper<Object, Text, Text, IntWritable> {
		
		private IntWritable one = new IntWritable(1);
        private Text word = new Text();

		@Override
		public void map(Object key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			// 获取单条数据记录
			String val = value.toString();
			UserLog log = JsonUtil.toObject(val, UserLog.class);
			// 设置要统计的维度--事件类型
            word.set(log.getEvent());
            output.collect(word, one);
		}

	}

	/**
	 * @description
	 * @author lianglong
	 */
	public class UserLogReducer extends MapReduceBase implements Reducer<Text, Text, Text, Object> {

		private IntWritable result = new IntWritable();
		
		@Override
		public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Object> output, Reporter reporter) throws IOException {
			 int sum = 0;
	            while (values.hasNext()) {
	                sum += values.next().getLength();
	            }
	            result.set(sum);
	            output.collect(key, result);
			
		}

	}

	public static void main(String[] args) throws IOException {
		String input = "hdfs://192.168.10.107:9000/user/hdfs/input/";
		// 因为output是hadoop动态生成的，所以指定的路径在文件系统上不能存在，否则会报异常--文件路径已存在
		String output = "hdfs://192.168.10.107:9000/user/hdfs/output111";

		JobConf conf = new JobConf(MapReduceTest.class);
		conf.setJobName("MapReduceTest");
		conf.addResource("classpath:/hadoop/core-site.xml");
		conf.addResource("classpath:/hadoop/hdfs-site.xml");
		conf.addResource("classpath:/hadoop/mapred-site.xml");
		
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);

		conf.setMapperClass(UserLogMap.class);
		conf.setCombinerClass(UserLogReducer.class);
		conf.setReducerClass(UserLogReducer.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);

		FileInputFormat.setInputPaths(conf, new Path(input));
		FileOutputFormat.setOutputPath(conf, new Path(output));

		JobClient.runJob(conf);
		System.exit(0);
	}

}
