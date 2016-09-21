package com.example.sh408.myapplication.UserInterFace.TextView;

//긴 문자열 생략해서 표시하기

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.sh408.myapplication.R;

public class setEllipsize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ellipsize);

        TextView textView = (TextView)findViewById(R.id.textView5);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setText("프로그램에서 설정한 생략 문자 : 반갑습니다. 봄여름가을겨울!");
    }
}
