package movierating;

import java.io.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;


public class MovieMapper extends Mapper <Object,Text,LongWritable,Text> {

	
	@Override
	public void map(Object key,Text value,Context context)throws IOException,InterruptedException
	{
		
		String []tokens = value.toString().split("\t");
		
		String movie_name = tokens[0];
		long  no_of_views = Long.parseLong(tokens[1]);
		
		no_of_views = (-1)*no_of_views;

		context.write(new LongWritable(no_of_views), new Text(movie_name));

	}
	
}