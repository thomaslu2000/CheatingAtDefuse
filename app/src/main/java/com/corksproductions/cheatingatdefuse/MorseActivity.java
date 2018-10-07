package com.corksproductions.cheatingatdefuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MorseActivity extends AppCompatActivity {

    String letter = "";
    String word = "";
    HashMap<String, String> codeToLetter = new HashMap<String, String>();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String[] morseLetters = {"· — ", "— · · · ", "— · — · ", "— · · ", "· ", "· · — · ", "— — · ", "· · · · ", "· · ", "· — — — ",
    "— · — ", "· — · · ", "— — ", "— · ", "— — — ", "· — — · ", "— — · — ", "· — · ", "· · · ", "— ", "· · — ", "· · · — ", "· — — ",
    "— · · — ", "— · — — ", "— — · · "};
    String[] checkedWords = {"sh", "h", "sl", "t", "box", "l", "str", "bi", "f", "bom", "bre", "bri",
    "ste", "sti", "v", "be"};
    String[] possibleWords = {"shell 3.505", "halls 3.515", "slick 3.522", "trick 3.532", "boxes 3.535", "leaks 3.542", "strobe 3.545", "bistro 3.552",
    "flick 3.555", "bombs 3.565", "break 3.572", "brick 3.575", "steak 3.582", "sting 3.592", "vector 3.595", "beats 3.600"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);
        for(int i=0; i<26; i++){
            codeToLetter.put(morseLetters[i], alphabet.substring(i, i+1));
        }
    }

    public void dot(View view){
        letter += "· ";
        updateLetter();
    }

    public void dash(View view){
        letter += "— ";
        updateLetter();
    }

    public void wordBreak(View view){
        String newLetter = codeToLetter.get(letter);
        if(newLetter == null){
            resetLetter(view);
            return;
        }
        word += newLetter;
        String wordText = "Word: " + word;
        ((TextView) findViewById(R.id.MorseWord)).setText(wordText);
        resetLetter(view);

        for(int i = 0; i < checkedWords.length; i++){
            String check = checkedWords[i];
            if(word.length() >= check.length() && word.substring(0, check.length()).equalsIgnoreCase(check)){
                String answer = "Answer: " + possibleWords[i] + " MHz";
                ((TextView) findViewById(R.id.MorseAnswer)).setText(answer);
                return;
            }
        }

    }

    public void updateLetter(){
        String letter_text = "Code: " + letter;
        ((TextView) findViewById(R.id.CodeWord)).setText(letter_text);
    }

    public void resetLetter(View view){
        letter = "";
        updateLetter();
    }

    public void resetWord(View view){
        word = "";
        String wordText = "Word: " + word;
        ((TextView) findViewById(R.id.MorseWord)).setText(wordText);
    }
}
