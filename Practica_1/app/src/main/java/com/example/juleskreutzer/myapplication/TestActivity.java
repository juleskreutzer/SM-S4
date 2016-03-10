package com.example.juleskreutzer.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TestActivity extends AppCompatActivity {

    private SeekBar bar;
    private ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bar = (SeekBar)findViewById(R.id.seekBar);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = seekBar.getProgress();
                ((TextView) findViewById(R.id.textView2)).setText(String.format("Slider value: %d", value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        toggle = (ToggleButton)findViewById(R.id.toggleButton);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton tb = (ToggleButton) v;
                boolean active = tb.isActivated();

                showMessageForToggleButton(active);
            }
        });

    }

    public void magicButtonOnClick(View v) {
        Button button = (Button) v;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Whoa!");
        builder.setMessage("You clicked the magic button!");
        builder.setCancelable(false);

        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                // current activity
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Place a nuke on this app", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TestActivity.this.finish();
            }
        });

        AlertDialog alert = builder.create();

        alert.show();
    }

    private void showMessageForToggleButton(boolean active) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(active){
            builder.setTitle("Yay");
            builder.setMessage("I'm activated!");
            builder.setCancelable(false);
            builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    dialog.cancel();
                }
            });
        }
        else {
            builder.setTitle("Uhh...");
            builder.setMessage("Why am I not activated?");
            builder.setCancelable(false);
            builder.setNegativeButton("Close me fast!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    // current activity
                    dialog.cancel();
                }
            });
        }
    }
}
