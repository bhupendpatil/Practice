package hk.ust.cse.comp107x.demogridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayAdapter<Integer> adapter;

    Integer list[] = {1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddingContentInGridView();
    }

    public void AddingContentInGridView(){

        gridView = (GridView) findViewById(R.id.gridView1);
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_gallery_item,list);
        gridView.setAdapter(adapter);

    }
}
