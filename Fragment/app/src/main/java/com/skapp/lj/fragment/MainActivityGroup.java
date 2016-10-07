package com.skapp.lj.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v){
        switch(v.getId()){
            case R.id.btn_finish:{
                finish();
                break;
            }
            case R.id.brn_run_sub_activity:
            {
                Intent intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
