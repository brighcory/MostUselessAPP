package com.merlin.bright.cory.mostuselessapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainMonsterActivity extends ActionBarActivity {
    private ImageButton mButton;
    int buttonClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_monster);
        mButton = (ImageButton) findViewById(R.id.click);
        final Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (buttonClicked){
                    case 1:
                    case 3:
                        ChangeButtonColor(MonsterData.redButton);
                        Grawl("grr");
                        mVibrator.vibrate(2000);

                        break;
                    case 5:
                    case 7:
                        ChangeButtonColor(MonsterData.redButton);
                        Grawl("grrrr");
                        break;

                    case 9:
                    case 11:
                        ChangeButtonColor(MonsterData.redButton);
                        Grawl("Grrrrr");
                        break;

                    case 13:
                    case 15:
                        ChangeButtonColor(MonsterData.redButton);
                        Grawl("GRRRRRRRRRRRR");
                        break;

                    default:
                        ChangeButtonColor(MonsterData.greenButton);
                        break;
                }

            }
        });

    }

    private void Grawl(String grawl) {
        Toast.makeText(MainMonsterActivity.this,
                grawl,
                Toast.LENGTH_SHORT).show();
    }

    private void ChangeButtonColor(int drawable) {

        mButton.setImageDrawable(getResources().getDrawable(drawable));
        buttonClicked++;
        if (buttonClicked == 16) buttonClicked = 0;

    }

    private void ChangeButtonTimer(){
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ChangeButtonColor(MonsterData.greenButton);

            }
        }, 2000);
    }

}
