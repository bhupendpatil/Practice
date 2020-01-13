import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Difference {

	public static class MyMapper
			extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text> {

		public void map(Object key, Text value, Context context
		) throws IOException, InterruptedException {
			String filename = Utils.getInputFileName(context);
			context.write(value, new Text(filename));
		}
	}

	public static class MyReducer
			extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, Text> {

		public void reduce(Text key, Iterable<Text> values,
						   Context context
		) throws IOException, InterruptedException {
			String files[] = new String[2];
			int i = 0;
			for (Text value : values) {
				files[i] = value.toString();
				i++;
			}
			if ( i == 1 && "A".equals(files[0]) ) {
				context.write(key, key);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf, "Word sum");
		job.setJarByClass(Difference.class);
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		Path input = new Path( args[0]);
		Path output = new Path(args[1]);

		FileInputFormat.addInputPath(job, input);
		FileOutputFormat.setOutputPath(job, output);
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}