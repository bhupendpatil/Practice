package hk.ust.cse.comp107x.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (Button) findViewById(R.id.checking);
        check.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] info = connectivityManager.getAllNetworkInfo();

        for(int i=0;i<info.length;i++){
            if(info[i].getState() == NetworkInfo.State.CONNECTED){
                Toast toast = Toast.makeText(this,"Internet is connected",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}