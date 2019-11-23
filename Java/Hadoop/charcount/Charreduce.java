import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Charreduce extends Reducer<Text,IntWritable, Text, IntWritable>{
  public void reduce(Text key,Iterable<IntWritable> values,Context context)throws IOException, InterruptedException{
    int count =0;
    IntWritable result = new IntWritable();
    for(IntWritable val: values){
      count +=val.get();
      result.set(count);
    }
    String found=key.toString();
    if (found.equals("a")|| found.equals("t")|| found.equals("c")||found.equals("g")){
      context.write(key, result);
    }
  }
}
