import java.io.IOException;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.io.*;

public class AveMapper extends 
       TableMapper<Text, FloatWritable> {
	
	private Text outState= new Text();
	private FloatWritable outStars = new FloatWritable();
	
	public void map(ImmutableBytesWritable row, Result columns, Context context)
	       throws IOException, InterruptedException {
		
		String tempStates = new String(columns.getValue("cf1".getBytes(), "state".getBytes()));
		outState.set(tempStates);
		
		String tempStars = new String(columns.getValue("cf1".getBytes(), "stars".getBytes()));
		
		float testing =  Float.parseFloat(tempStars);
	//	int test = Math.round(testing); //very crude!
		//stars.set(Integer.parseInt(tempStars));
		//int test = 123;
		outStars.set(testing); 
		
		context.write(outState, outStars);
	}

}