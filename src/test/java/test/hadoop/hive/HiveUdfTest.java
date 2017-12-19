package test.hadoop.hive;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * @description 
 * @author lianglong
 */
public class HiveUdfTest extends UDF {
	
	public Text evaluate(Text a , Text b){
		return new Text(a.toString() + "***" + b.toString());
	}

}
