package com.deneme.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    Button start,stop;
    TextView count;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.button);
        stop=findViewById(R.id.button2);
        count=findViewById(R.id.textView2);

        number=0;
    }


    public void start (View view){

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {

                count.setText("Time : " + number);
                number++;
                count.setText("Time : " + number);
                handler.postDelayed(runnable,1000);
                start.setEnabled(false);

            }
        };
        handler.post(runnable);

    }

    public void stop(View view){
        start.setEnabled(true);
        handler.removeCallbacks(runnable); // close runnable

    }

}