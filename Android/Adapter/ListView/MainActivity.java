package hk.ust.cse.comp107x.demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<Integer> adapter;

    Integer list[] = {1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddingContentInGridView();
    }

    public void AddingContentInGridView(){

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_gallery_item,list);
        listView.setAdapter(adapter);

    }
}
