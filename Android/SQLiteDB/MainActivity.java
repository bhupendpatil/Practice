package tk.bhupend.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvData;
    private toDoDatabaseHelper dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAccess = new toDoDatabaseHelper(this);
        lvData = (ListView) findViewById(R.id.lvData);
        items = new ArrayList<String>();
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvData.setAdapter(itemsAdapter);
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TaskDetails.class);
                intent.putExtra("data", lvData.getItemAtPosition(position).toString());
                startActivity(intent);
                // Refresh the adapter
                refreshListView();
            }
        });
    }

    public void AddItem(View v) {
        EditText txtItem = (EditText) findViewById(R.id.txtItem);
        String itemText = txtItem.getText().toString();
        itemsAdapter.add(itemText);
        txtItem.setText("");
        dbAccess.addTask(itemText);
    }

    public void readItems() {
        try {
            items = new ArrayList<String>(dbAccess.getAllTasks());
        } catch (Exception e) {
            items = new ArrayList<String>();
        }
    }

    public void refreshListView() {
        itemsAdapter.notifyDataSetChanged();
    }
}