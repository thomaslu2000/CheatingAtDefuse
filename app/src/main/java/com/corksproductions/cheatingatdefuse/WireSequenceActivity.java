package com.corksproductions.cheatingatdefuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class WireSequenceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner[] colorSpinners, letterSpinners;
    TextView[] texts;
    int[] counters = {0, 0, 0};
    int level = 1;
    int[] tempCounters;
    String[][] cuts = {{"C", "B", "A", "AC", "B", "AC", "ABC", "AB", "B"},
                        {"B", "AC", "B", "A", "B", "BC", "C", "AC", "A"},
                        {"ABC", "AC", "B", "AC", "B", "BC", "AB", "C", "C"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wire_sequence);

        TextView[] c = {((TextView) findViewById(R.id.FirstIndex)), ((TextView) findViewById(R.id.SecondIndex)), ((TextView) findViewById(R.id.ThirdIndex))};
        texts = c;

        // Spinner element
        Spinner[] a = {(Spinner) findViewById(R.id.ColorSpinner1), (Spinner) findViewById(R.id.ColorSpinner2), (Spinner) findViewById(R.id.ColorSpinner3)};
        colorSpinners = a;

        Spinner[] b = {(Spinner) findViewById(R.id.LetterSpinner1), (Spinner) findViewById(R.id.LetterSpinner2), (Spinner) findViewById(R.id.LetterSpinner3)};
        letterSpinners = b;

        // Spinner click listener
        for(Spinner s : colorSpinners) s.setOnItemSelectedListener(this);
        for(Spinner s : letterSpinners) s.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Black");
        ArrayList<String> letters = new ArrayList<String>();
        letters.add("A");
        letters.add("B");
        letters.add("C");

        // Creating adapter for spinner
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colors);
        ArrayAdapter<String> letterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letters);

        // Drop down layout style - list view with radio button
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        letterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        for(Spinner s : colorSpinners) s.setAdapter(colorAdapter);
        for(Spinner s : letterSpinners) s.setAdapter(letterAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void calculate(View view){
        int[] cs = counters.clone();  // red, blue, black
        boolean cut;
        for(int i = 0; i<3;i++){
            String color = colorSpinners[i].getSelectedItem().toString();
            String letter = letterSpinners[i].getSelectedItem().toString();
            int colIndex = color.equals("Red") ? 0 : color.equals("Blue") ? 1 : 2;
            cut = cuts[colIndex][cs[colIndex]].contains(letter);
            String text = "Wire " + (level + i) + ": " + (cut ? "Cut" : "Don't Cut");
            texts[i].setText(text);
            cs[colIndex]++;
        }
        tempCounters = cs;
    }
    public void next(View view){
        level += 3;
        for(int i = 0; i<3;i++){
            String text = "Wire " + (level + i) + ": ";
            texts[i].setText(text);
        }
        counters = tempCounters;
    }
}
