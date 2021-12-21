package com.example.a802_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity {

    Intent si;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tv = findViewById(R.id.text1);
        tv.setText("Author : Noa Shetrit\n\n" +
                "Description: hiii :)\n" +
                "the application gives you 4 options:\n" +
                "1 - change background color by basic color (blue, yellow, red)\n" +
                "2 - change background color by mixing the basic color (blue, yellow, red)\n" +
                "3 - set background color to white\n" +
                "4 - enter a text and turn it to a toast message\n" +
                "this program work with alert dialog and helped me practise the subject.\n" +
                "Have a gooood day ;))) " );
    }

    public void back(View view) {
        //return to main activity
        si = new Intent(this, MainActivity.class);
        startActivity(si);
    }
}