package wordcountjob;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountJob extends Configured implements Tool{
    public int run(String[]args) throws Exception {
        JobConf conf =new JobConf(getConf(),WordCountJob.class);
        conf.setJobName("WordCount");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        conf.setMapperClass(WordCountMapper.class);
        conf.setReducerClass(WordCountReducer.class);
        Path inp =new Path(args[0]);
        Path out=new Path(args[1]);
        FileInputFormat.addInputPath(conf, inp);
        FileOutputFormat.setOutputPath(conf,out);
        JobClient.runJob(conf);
        return 0;
    }

    public static void main(String[]args) throws Exception{
        int res = ToolRunner.run(new Configuration(), new WordCountJob(),args);
        System.exit(res);
    }
}
