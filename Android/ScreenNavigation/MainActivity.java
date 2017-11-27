
package hk.ust.cse.comp107x.demoactivityswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.buttonClick:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
