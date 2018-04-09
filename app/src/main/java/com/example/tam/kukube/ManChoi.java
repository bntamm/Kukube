package com.example.tam.kukube;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tam on 2/28/2018.
 */

public class ManChoi extends AppCompatActivity {
    TextView txtTime , txtScore;
    GridView gvMau;
    ImageButton imgReplay;
    TaoMauNgauNhien taoMauNgauNhien = new TaoMauNgauNhien();
    ArrayList arr;
    int score,soO, checkTime = 0;


    //Bộ đếm thời gian
    CountDownTimer countDownTimer = new CountDownTimer(5000, 10) {

        public void onTick(long millisUntilFinished) {
            txtTime.setText(millisUntilFinished / 10+ "");
        }

        public void onFinish() {
            checkTime = 1;
            txtTime.setText("0");

        }};


@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_man_choi);
        AnhXa();
        setupGridView();
        setupDataGridView();
        setSuKienClick();
        Replay();


    }

    private void AnhXa(){
        gvMau = (GridView) findViewById(R.id.gridviewKuKuBe);
        txtScore = (TextView) findViewById(R.id.textViewScore);
        txtTime = (TextView) findViewById(R.id.textViewTime);
        imgReplay = (ImageButton) findViewById(R.id.imageButtonReplay);
        score = 0;

    }

    private void setupGridView(){
        if(score < 10){
            gvMau.setNumColumns(2);
            soO = 4;
        }else {

            gvMau.setNumColumns(score/10+2);
            soO = (score/10+2)*(score/10+2);

        }


    }

    private void setupDataGridView(){
        arr = new ArrayList(taoMauNgauNhien.taoBangMau(soO));
        Adapter adapter = new Adapter(ManChoi.this , R.layout.layout_man_choi , arr);
        gvMau.setAdapter(adapter);
        txtScore.setText(Integer.toString(score));

    }

    //bắt sự kiện khi user click vào sẽ chuyển qua màu khác
    private void setSuKienClick(){
        gvMau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == taoMauNgauNhien.dapAn && checkTime == 0){
                setupGridView();
                countDownTimer.start();
                score = score + 3;
                setupDataGridView();

            }
            }
        });

    }

    private void Replay(){
        imgReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkTime == 1  ){
                    checkTime = 0;
                    countDownTimer.start();
                    AnhXa();
                    setupGridView();
                    setupDataGridView();
                    setSuKienClick();
            }}
        });
    }


}
