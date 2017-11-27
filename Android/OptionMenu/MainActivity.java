package hk.ust.cse.comp107x.demooptionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.Item1:
                Toast.makeText(getApplicationContext(),"Item 1 selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Item2:
                Toast.makeText(getApplicationContext(),"Item 2 selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Item3:
                Toast.makeText(getApplicationContext(),"Item 3 selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }
}
