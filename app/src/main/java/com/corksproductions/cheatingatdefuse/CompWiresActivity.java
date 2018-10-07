package com.corksproductions.cheatingatdefuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CompWiresActivity extends AppCompatActivity {

    int red, blue, star, led;
    boolean sbutton,pbutton, bbutton;
    int[] procedures = {1, 0, 1, 4, 2, 3, 0, 3, 2, 4, 1, 4, 2, 2, 3, 0};
    // 1 is cut, 0 is don't, 2 is S, 3 is P, 4 is B
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_wires);
        red = blue = star = led = 0;
        sbutton =  pbutton = bbutton = false;
    }

    public void recalculate(){
        int[] options = {red, blue, star, led};
        int area = 0;
        for(int i : options){
            area = (area << 1) + i;
        }
        int p = procedures[area];
        String text;
        text = p == 1 || p == 2 && sbutton || p == 3 && pbutton || p == 4 && bbutton ?
                "Cut it" : "Don't cut it";
        ((TextView) findViewById(R.id.CompWireText)).setText(text);

    }

    public void redButton(View view){
        red = 1 - red;
        String text = red == 1 ? "Is Red" : "Not Red";
        ((Button) findViewById(R.id.RedButton)).setText(text);
        recalculate();
    }

    public void blueButton(View view){
        blue = 1 - blue;
        String text = blue == 1 ? "Is Blue" : "Not Blue";
        ((Button) findViewById(R.id.BlueButton)).setText(text);
        recalculate();
    }

    public void starButton(View view){
        star = 1 - star;
        String text = star == 1 ? "Has Star" : "No Star";
        ((Button) findViewById(R.id.StarButton)).setText(text);
        recalculate();
    }

    public void ledButton(View view){
        led = 1 - led;
        String text = led == 1 ? "LED on" : "LED off";
        ((Button) findViewById(R.id.LedButton)).setText(text);
        recalculate();
    }

    public void sButton(View view){
        sbutton = !sbutton;
        String text = sbutton ? "Last Digit of Serial is Even" : "Last Digit of Serial is Odd";
        ((Button) findViewById(R.id.SButton)).setText(text);
        recalculate();
    }

    public void pButton(View view){
        pbutton = !pbutton;
        String text = pbutton ? "Bomb has parallel port" : "Bomb has no parallel port";
        ((Button) findViewById(R.id.PButton)).setText(text);
        recalculate();
    }

    public void bButton(View view){
        bbutton = !bbutton;
        String text = bbutton ? "Bomb has at least 2 Batteries" : "Bomb has less than 2 Batteries";
        ((Button) findViewById(R.id.BButton)).setText(text);
        recalculate();
    }
}
