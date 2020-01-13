import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/**
 * Created by m on 18.03.15.
 */
public class Utils {
	public static String getInputFileName(Mapper.Context context) {
		return ((FileSplit) context.getInputSplit()).getPath().getName();
	}
}
