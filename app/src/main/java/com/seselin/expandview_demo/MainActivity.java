package com.seselin.expandview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.seselin.View.ExpandLayout;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        initExpandView();
    }

    private ExpandLayout mExpandLayout;

    public void initExpandView() {
        mExpandLayout = (ExpandLayout) findViewById(R.id.expandLayout);
        mExpandLayout.initExpand(false);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mExpandLayout.toggleExpand();
            }
        });
    }
}
