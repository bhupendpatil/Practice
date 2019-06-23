package tk.bhupend.imgdown;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.net.URL;
import static tk.bhupend.imgdown.R.id.imageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageview;
    Drawable d;
    //Image URL to be downloaded from the internet
    String IMAGE_URL ="https://images.unsplash.com/photo-1529321044792-949d1f03e61e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=890&q=80";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView) findViewById(imageView);
    }

    public void DownloadImage(View v) {
        new DownloadImageTask().execute(IMAGE_URL) ;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */
        protected Drawable doInBackground(String... urls) {
            return loadImageFromNetwork(urls[0]);
        }
        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(Drawable result) {
            imageview.setImageDrawable(result);
        }
    }
    
    //Download Image From Network
    private Drawable loadImageFromNetwork(String imageUrl) {
        Drawable drawable = null;
        try {
            drawable = Drawable.createFromStream(new
                    URL(imageUrl).openStream(),"image");
        } catch (IOException e) {
            Log.d("Error", e.getMessage());
        }
        return drawable ;
    }
}

