package charcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Charmap extends Mapper<LongWritable, Text, Text, IntWritable> {
  public void map(LongWritable key, Text value,Context context) throws IOException,InterruptedException{
    String line=value.toString();
    char[] carr=line.toCharArray();
    for(char c:carr){
      System.out.println(c);
      context.write(new Text(String.valueOf(c)), new IntWritable(1));
    }
  }
}
