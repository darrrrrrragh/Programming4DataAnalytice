import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.*;


public class AveReducerToHBase extends
        TableReducer<Text, FloatWritable, ImmutableBytesWritable>{


    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {

        float sum = 0;
        float ave = 0;
        float count = 0;

        for (FloatWritable val : values) {
            sum += val.get();
            count = count +1;
        }
        ave = sum/count;
        count = 0;


        /*Put put = new Put(Bytes.toBytes(key.toString()));
        put.addColumn("cf1".getBytes(), "stars".getBytes(), Bytes.toBytes(Float.toString(ave)));*/


        context.write(key, ave);
    }


}
