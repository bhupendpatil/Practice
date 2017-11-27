package hk.ust.cse.comp107x.democalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result;
    Button addButton, minusButton, multiButton, divButton;
    EditText firstNumber, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        addButton = (Button) findViewById(R.id.addButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        multiButton = (Button) findViewById(R.id.multiButton);
        divButton = (Button) findViewById(R.id.divButton);

        addButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        multiButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        firstNumber = (EditText) findViewById(R.id.firstNumber);
        secondNumber = (EditText) findViewById(R.id.secondNumber);
        result = (TextView) findViewById(R.id.resultView);

        int a = Integer.parseInt(firstNumber.getText().toString());
        int b = Integer.parseInt(secondNumber.getText().toString());
        int c;


        switch (v.getId()) {
            case R.id.addButton:
                result.setText("");
                c = a + b;
                result.setText(" " + c);
                break;
            case R.id.minusButton:
                result.setText("");
                c = a - b;
                result.setText(" " + c);
                break;
            case R.id.multiButton:
                result.setText("");
                c = a * b;
                result.setText(" " + c);
                break;
            case R.id.divButton:
                result.setText("");
                c = a / b;
                result.setText(" " + c);
                break;
            default:
                break;
        }
    }
}
