package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    TextView t1,t2;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a=Double.parseDouble(e1.getText().toString());
                double b=Double.parseDouble(e2.getText().toString());
                double bmi=a/(b*b);
                t1.setText((""+bmi).substring(0,7));
                if(bmi<18.5)
                    t2.setText("Underweight");
                else if(bmi<24.9)
                    t2.setText("Healthy");
                else if(bmi<29.9)
                    t2.setText("Overweight");
                else
                    t2.setText("Obesity");

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("0");
                t2.setText("");
                e1.setText("");
                e2.setText("");

            }
        });


    }
}