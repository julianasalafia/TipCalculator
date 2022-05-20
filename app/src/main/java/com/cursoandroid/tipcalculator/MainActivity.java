package com.cursoandroid.tipcalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText amount;
    private TextView percent;
    private TextView tip;
    private TextView total;
    private SeekBar seekbarTip;

    private double percentage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        percent = findViewById(R.id.percent);
        tip = findViewById(R.id.textTip);
        total = findViewById(R.id.textTotal);
        seekbarTip = findViewById(R.id.seekBar);

        seekbarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentage = progress;
                percent.setText(Math.round(percentage) + " %");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate() {
        String recoveredValue = amount.getText().toString();
        if (recoveredValue == null || recoveredValue.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Type an amount first!",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            double typedValue = Double.parseDouble(recoveredValue);

            double textTip = typedValue * (percentage / 100);
            double textTotal = textTip + typedValue;

            tip.setText("US$ " + Math.round(textTip));
            total.setText("US$ " + textTotal);
        }
    }
}
