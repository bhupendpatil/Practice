import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Join {

	public static class MyMapper
			extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text> {

		public void map(Object key, Text value, Context context
		) throws IOException, InterruptedException {
			String filename = Utils.getInputFileName(context);

			if (value.toString().isEmpty()) {
				return;
			}

			Text res;
			String values[] = value.toString().split(" ");
			Text b;

			if ("A".equals(filename)) {
				res = new Text("A" + "\t" + values[1]);
				b = new Text(values[0]);
			} else {
				res = new Text("B" + "\t" + values[0]);
				b = new Text(values[1]);
			}

			context.write(b, res);
		}
	}

	public static class MyReducer
			extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, Text> {

		public void reduce(Text key, Iterable<Text> values,
						   Context context
		) throws IOException, InterruptedException {
			List<String> A = new ArrayList<String>();
			List<String> B = new ArrayList<String>();

			for (Text value : values) {
				String tp[] = value.toString().split("\t");
				String filename = tp[0];
				String col = tp[1];
				if ("A".equals(filename)) {
					A.add(col);
				} else {
					B.add(col);
				}
			}

			for ( String a : A ) {
				for (String b : B) {
					context.write(key, new Text(a + "\t" + b));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf, "Word sum");
		job.setJarByClass(Join.class);
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