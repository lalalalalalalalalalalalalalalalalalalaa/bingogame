package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Button> buttons = new LinkedList<>();
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(n > 0){

            for (int i = 0; i < Math.pow(n, 2); i++) {
                Button button = new Button(this);
                button.setId(i + 1);


                buttons.add(button);

            }
        }

    }
}