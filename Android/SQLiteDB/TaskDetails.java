package tk.bhupend.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class TaskDetails extends AppCompatActivity {
    private toDoDatabaseHelper dbAccess;
    String oldvalue="";
    EditText txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        //code to enable the back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //code to fetch the selected list item data in the previous activity
        dbAccess = new toDoDatabaseHelper(this);
        Intent intent = getIntent();
        oldvalue = intent.getStringExtra("data");
        txtData = (EditText) findViewById(R.id.txtData);
        txtData.setText(intent.getStringExtra("data"));
    }

    //code for delete button to delete the task
    protected void Delete(View v) {
        dbAccess.deleteTask(txtData.getText().toString());
        Intent intent = new Intent(TaskDetails.this,MainActivity.class) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    //code for delete button to update the task
    protected void Update(View v) {
        dbAccess.updateTask(oldvalue, txtData.getText().toString());
        Intent intent = new Intent(TaskDetails.this,MainActivity.class) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    //code to close the current activity and move to the previous
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}