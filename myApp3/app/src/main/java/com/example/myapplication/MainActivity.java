//Attendance system
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox c[]=new CheckBox[10];
    Button b1,b2,b3,b4;
    

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
        c[0]=findViewById(R.id.checkBox3);
        c[1]=findViewById(R.id.checkBox);
        c[2]=findViewById(R.id.checkBox2);
        c[3]=findViewById(R.id.checkBox4);
        c[4]=findViewById(R.id.checkBox5);
        c[5]=findViewById(R.id.checkBox6);
        c[6]=findViewById(R.id.checkBox7);
        c[7]=findViewById(R.id.checkBox8);
        c[8]=findViewById(R.id.checkBox9);
        c[9]=findViewById(R.id.checkBox10);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

//        int a=0;

        b1.setOnClickListener(new View.OnClickListener() {//this button is for all present
            @Override
            public void onClick(View v) {
                for(int i=0;i<10;i++)
                {
                    c[i].setChecked(true);//set all the checkbox to true
//                    a=10;
                }
                for(int i=0;i<10;i++)
                {
                    c[i].setBackgroundResource(R.color.green);//set all the checkbox to true
//                    a=10;
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {//this button is for all absent
            @Override
            public void onClick(View v) {
                for(int i=0;i<10;i++)
                {
                    c[i].setChecked(false);//set all the checkbox to false
                }
                for(int i=0;i<10;i++)
                {
                    c[i].setBackgroundResource(R.color.red);//set all the checkbox to true
//                    a=10;
                }

            }
        });
        b3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=0;
                for(int i=0;i<10;i++)
                {
                    if(c[i].isChecked()==true)
                    {
                        a++;
                        c[i].setBackgroundResource(R.color.green);
                    }else{
                        c[i].setBackgroundResource(R.color.red);
                    }
                }
                Toast.makeText(MainActivity.this, "Total students present:"+a, Toast.LENGTH_SHORT).show();

            }
        }));
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<10;i++)
                {
                    c[i].setChecked(false);
                    c[i].setBackgroundResource(R.color.white);
                }
            }
        });






    }
}