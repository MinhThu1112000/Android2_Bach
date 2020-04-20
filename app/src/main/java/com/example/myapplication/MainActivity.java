package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   TextView txtDiem;
   ImageButton imgBtn;
   SeekBar sbOne, sbTwo, sbThree;
   CheckBox cbOne, cbTwo, cbThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number  = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                sbOne.setProgress(sbOne.getProgress() + one);
                if(sbOne.getProgress() >= sbOne.getMax()){
                    this.cancel();
                    imgBtn.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"ONE WIN",Toast.LENGTH_SHORT);
                }
                if(sbTwo.getProgress() >= sbTwo.getMax()){
                    this.cancel();
                    imgBtn.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT);
                }
                if(sbThree.getProgress() >= sbThree.getMax()){
                    this.cancel();
                    imgBtn.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT);
                }
                sbTwo.setProgress(sbTwo.getProgress() + two);
                sbThree.setProgress(sbThree.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sbOne.setProgress(0);
                sbTwo.setProgress(0);
                sbThree.setProgress(0);
                imgBtn.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }
    private void AnhXa(){
        txtDiem = (TextView) findViewById(R.id.txtDiemSo);
        imgBtn  = (ImageButton) findViewById(R.id.imgBtn);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        sbOne = (SeekBar) findViewById(R.id.seeBarOne);
        sbTwo = (SeekBar) findViewById(R.id.seeBarTwo);
        sbThree = (SeekBar) findViewById(R.id.seeBarThree);


    }
}
