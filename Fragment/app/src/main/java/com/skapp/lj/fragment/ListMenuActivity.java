package com.skapp.lj.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListMenuActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView mListView = null;
    OnListItemClickListener mListItemClickListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        mListView = (ListView)findViewById(R.id.listview);

        mListView.setOnItemClickListener(this);
    }
    public interface  OnListItemClickListener
    {
        void onItemClcik(Intent viewerIntent, String viewerId);
    }
    public void setOnListItemClickListener(OnListItemClickListener ln)
    {
        mListItemClickListener = ln;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Intent startViewrActivityIntetnt = new Intent();
        String viewerActivityId = null;

        switch (position){
            case 0:
                startViewrActivityIntetnt.setClass(this, TextViewerActivity.class);
                viewerActivityId = "TextViewerActivity";
                break;

            case 1:
                startViewrActivityIntetnt.setClass(this, ImageViewerActivity.class);
                viewerActivityId = "ImageViewerActivity";
                break;

            case 2:
                startViewrActivityIntetnt.setAction(Intent.ACTION_MAIN);
                startViewrActivityIntetnt.addCategory(Intent.CATEGORY_APP_CALCULATOR);
                viewerActivityId = "Calculator";
                break;
        }
        if(mListItemClickListener != null){
            mListItemClickListener.onItemClcik(startViewrActivityIntetnt,viewerActivityId);
        }
    }
}
