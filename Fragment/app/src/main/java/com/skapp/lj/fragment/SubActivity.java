package com.skapp.lj.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
    public void OnClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_finish:
            {
                finish();
                break;
            }
        }
    }
}
