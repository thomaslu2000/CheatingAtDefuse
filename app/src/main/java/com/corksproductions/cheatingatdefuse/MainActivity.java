package com.corksproductions.cheatingatdefuse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchMorseActivity(View view) {
        intent=new Intent(this, MorseActivity.class);
        startActivity(intent);
    }

    public void launchCompWiresActivity(View view) {
        intent=new Intent(this, CompWiresActivity.class);
        startActivity(intent);
    }

    public void launchWireSeqActivity(View view) {
        intent=new Intent(this, WireSequenceActivity.class);
        startActivity(intent);
    }
}
