package tk.bhupend.internaldb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void writeData(View v){
        try {
            String FILENAME = "demo.txt";
            String data = "";
            EditText txtData = (EditText) findViewById(R.id.txtData);
            data = txtData.getText().toString();
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            txtData.setText("");
            Toast.makeText(MainActivity.this,"FileCreated",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(View v){
        try {
            String FILENAME = "demo.txt";
            FileInputStream fin = openFileInput(FILENAME);
            int c;
            String temp="";
            while( (c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            fin.close();
            //string temp contains all the data of the file.
            Toast.makeText(MainActivity.this,temp,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
