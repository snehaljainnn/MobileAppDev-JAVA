package com.example.radiobutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1,rg2;
    Button b1,b2;
    ConstraintLayout cl;


    @SuppressLint("MissingInflatedId")
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
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        rg1=findViewById(R.id.branch);
        rg2=findViewById(R.id.year);
        cl=findViewById(R.id.main);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton rx=findViewById(checkedId);

                if(checkedId!=-1)
                {
                    String s1=rx.getText().toString();
                    if (s1.equals("MBA TECH CE"))
                    {
                        cl.setBackgroundResource(R.color.pink);
                    }else if(s1.equals("Btech CE"))
                    {
                        cl.setBackgroundResource(R.color.pink3);
                    }else if(s1.equals("Btech AIDS"))
                    {
                        cl.setBackgroundResource(R.color.pink2);
                    }
                }else {
                    cl.setBackgroundResource(R.color.white);
                    Toast.makeText(MainActivity.this, "Cleared", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rx=findViewById(rg1.getCheckedRadioButtonId());
                RadioButton ry=findViewById(rg2.getCheckedRadioButtonId());
                if(rg1.getCheckedRadioButtonId()!=-1 && rg2.getCheckedRadioButtonId()!=-1)
                {
                    String s1="You are a student of "+rx.getText().toString()+" "+ry.getText().toString();
                    Toast.makeText(MainActivity.this, s1, Toast.LENGTH_SHORT).show();
                }
                else if(rg1.getCheckedRadioButtonId()!=-1)
                {
                    Toast.makeText(MainActivity.this, "Select branch", Toast.LENGTH_SHORT).show();
                }else if(rg1.getCheckedRadioButtonId()!=-1)
                {
                    Toast.makeText(MainActivity.this, "Select year", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "Select branch and year", Toast.LENGTH_SHORT).show();
                    cl.setBackgroundResource(R.color.white);
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg1.clearCheck();
                rg2.clearCheck();
                cl.setBackgroundResource(R.color.white);
            }
        });



    }
}