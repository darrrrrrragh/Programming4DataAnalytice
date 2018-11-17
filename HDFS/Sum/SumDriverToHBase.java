import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.GenericOptionsParser;


public class SumDriverToHBase {
	public static void main(String[] args) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		//String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		//if (otherArgs.length != 0) {
		//    System.err.println("Usage: HBaseSummarisationDriver2");
		//    System.exit(2);
	  //  	}
		Scan scan = new Scan();
		Job job = Job.getInstance(conf, "Count frequency of category in HBase businesscatNEW table.");
		job.setJarByClass(SumDriverToHBase.class);
		TableMapReduceUtil.initTableMapperJob("businesscatNEW", scan, 
				                              SumMapper.class,
				                              Text.class, IntWritable.class, 
				                              job);
		TableMapReduceUtil.initTableReducerJob("businesscatCount1", SumReducerToHBase.class, job);
		job.setNumReduceTasks(1);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
		}
}

