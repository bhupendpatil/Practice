import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Union {

	private static Text emptyWord = new Text("");
	public static class Mapper
			extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text> {

		public void map(Object key, Text value, Context context
		) throws IOException, InterruptedException {
			context.write(value, emptyWord);
		}
	}

	public static class Reducer
			extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, Text> {

		public void reduce(Text key, Iterable<Text> _values,
						   Context context
		) throws IOException, InterruptedException {
				context.write(key, key);
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf, "Word sum");
		job.setJarByClass(Union.class);
		job.setMapperClass(Mapper.class);
		job.setCombinerClass(Reducer.class);
		job.setReducerClass(Reducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		Path input = new Path( args[0]);
		Path output = new Path(args[1]);

		FileInputFormat.addInputPath(job, input);
		FileOutputFormat.setOutputPath(job, output);
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}