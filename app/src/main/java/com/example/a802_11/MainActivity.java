package com.example.a802_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author		Noa Shetrit noashetrit@gmail.com
 * @version	1.1
 * @since		21/12/2021
 * This application work with Alert Dialog
 * and show us many options we can do like
 * change back ground by picking colors or
 * input text into a toast message with this custom.
 */

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb1, adb2, adb3;
    AlertDialog ad1, ad2, ad3;
    final int[] color = {Color.RED,Color.YELLOW,Color.BLUE};
    final String[] colors = {"Red","Yellow","Blue"};
    LinearLayout llayout;
    String str;
    boolean pressed;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        adb1 = new AlertDialog.Builder(this);
        adb2 = new AlertDialog.Builder(this);
        adb3 = new AlertDialog.Builder(this);
        llayout = findViewById(R.id.Ll);
    }

    public void setBGcolor(View view) {
        int[] color = {0,0,0};
        adb1.setTitle("Choose background color (only one at time)");
        adb1.setCancelable(false);
        adb1.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                llayout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });

        ad1 = adb1.create();
        ad1.show();
    }

    public void setBGmultiColor(View view) {
        int[] color = {0,0,0};
        pressed = false;
        adb2.setCancelable(false);
        adb2.setTitle("Choose the colors you want to combine:");
        adb2.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                if(pressed) pressed = false;
                else pressed = true;
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });
        adb2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (pressed) {
                    llayout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
                } else {
                    dialogInterface.dismiss();
                }
            }
        });

        ad2 = adb2.create();
        ad2.show();
    }

    public void setBGwhite(View view) {
        llayout.setBackgroundColor(Color.WHITE);

    }

    public void textToToast(View view) {
        adb3.setTitle("Enter text: ");
        adb3.setMessage("enter some text that you want turn it as a toast");
        adb3.setCancelable(false);
        final EditText et = new EditText(this);
        et.setHint("type text here..");
        adb3.setView(et);
        adb3.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!et.equals("")) str = et.getText().toString();
                else str = "*system message* -\n you didn't write nothing..";
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();

            }
        });

        adb3.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        ad3 = adb3.create();
        ad3.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        si = new Intent(this,credits.class);
        startActivity(si);
        return true;
    }
}