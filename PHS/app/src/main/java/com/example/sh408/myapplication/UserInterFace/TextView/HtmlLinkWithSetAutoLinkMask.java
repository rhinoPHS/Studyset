//링크
package com.example.sh408.myapplication.UserInterFace.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import com.example.sh408.myapplication.R;

import org.w3c.dom.Text;

public class HtmlLinkWithSetAutoLinkMask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_link_with_set_auto_link_mask);

        TextView txtPhone = (TextView)findViewById(R.id.textView);
        Linkify.addLinks(txtPhone,Linkify.PHONE_NUMBERS);

        TextView txtPhone2 = (TextView)findViewById(R.id.textView3);
        Linkify.addLinks(txtPhone2,Linkify.PHONE_NUMBERS);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setAutoLinkMask(Linkify.WEB_URLS);
        textView2.setText("프로그램에서 설정한 URL http://www.infopub.co.kr/");
    }
}
