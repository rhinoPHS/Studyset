//마키는 전광판처럼 오른쪽에서 왼쪽으로 진행돼 긴 문자열을 생략하지 않고 할 수 있다.
//사용하려면 singleLine속성과 focusable 관련 속성 지정돼야 함
//두개의 텍스트뷰에 마퀴를 적용하면 맨 처음거 하나만 작동함.
// 왜 인지, 두 개다 작동하게 할 순 없는지 나중에 알아보기
// 더불어 터치하면 멈추게 할 순 없는지
// 한 번 돌고나서 끝나는데 계속하게 할 순 없는지 무한으로~

package com.example.sh408.myapplication.UserInterFace.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.sh408.myapplication.R;

public class setEllipsizeMarquee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ellipsize_marquee);

        TextView txt_marquee = (TextView)findViewById(R.id.textView7);
        txt_marquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        txt_marquee.setSingleLine(true);
        txt_marquee.setFocusable(true);
        txt_marquee.setFocusableInTouchMode(true);
        txt_marquee.setText("마키표시 텍스트, 프로그램에서 포커스 설정dffsdfdfdfdffdfdf");
    }
}
