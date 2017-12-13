import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.*;


public class SumReducer2 extends
       TableReducer<Text, IntWritable, ImmutableBytesWritable>{
	

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
	       throws IOException, InterruptedException {
		
		int sum = 0;
		
		for (IntWritable val : values) {
			sum += val.get();
		}
		
		Put put = new Put(Bytes.toBytes(key.toString()));
		put.addColumn("cf1".getBytes(), "count".getBytes(), Bytes.toBytes(Integer.toString(sum)));
		
		context.write(null, put);
	}
	

}

