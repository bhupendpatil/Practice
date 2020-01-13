import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class GroupSum {

	public static class MyMapper
			extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, IntWritable> {

		public void map(Object key, Text value, Context context
		) throws IOException, InterruptedException {
			String[] splitArr = value.toString().split("\t");
			if ( splitArr.length > 1 ) {
				IntWritable intWritable = new IntWritable(Integer.parseInt(splitArr[1]));
				context.write(new Text(splitArr[0]), intWritable);
			}
		}
	}

	public static class MyReducer
			extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {

		public void reduce(Text key, Iterable<IntWritable> values,
						   Context context
		) throws IOException, InterruptedException {
			int sum = 0;
			for(IntWritable intWritable : values) {
				sum += intWritable.get();
			}
			context.write(key, new IntWritable(sum));
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf, "Word sum");
		job.setJarByClass(GroupSum.class);
		job.setMapperClass(MyMapper.class);
		job.setCombinerClass(MyReducer.class);
		job.setReducerClass(MyReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		Path input = new Path( args[0]);
		Path output = new Path(args[1]);

		FileInputFormat.addInputPath(job, input);
		FileOutputFormat.setOutputPath(job, output);
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}