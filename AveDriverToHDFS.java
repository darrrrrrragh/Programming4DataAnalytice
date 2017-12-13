import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.GenericOptionsParser;


public class AveDriverToHBase {
    public static void main(String[] args) throws Exception {
        Configuration conf = HBaseConfiguration.create();
        //String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        //if (otherArgs.length != 0) {
        //    System.err.println("Usage: HBaseSummarisationDriver2");
        //    System.exit(2);
        //  	}
        Scan scan = new Scan();
        Job job = Job.getInstance(conf, "Average stars per state businesscatNEW table.");
        job.setJarByClass(AveDriverToHBase.class);
        TableMapReduceUtil.initTableMapperJob("businesscatNEW", scan,
                AveMapper.class,
                Text.class, FloatWritable.class,
                job);
        job.setReducerClass(AveReducerToHDFS.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FloatWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);
        FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:54310/user/hduser/Avg1/output"));



        //TableMapReduceUtil.initTableReducerJob("businesscatAvg1", AveReducerToHBase.class, job);
        job.setNumReduceTasks(1);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
