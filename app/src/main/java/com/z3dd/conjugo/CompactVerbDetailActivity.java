package com.z3dd.conjugo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
public abstract class CompactVerbDetailActivity extends AppCompatActivity {

    private TextView verbNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_verb_detail_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.verb_detail_layout);
        RelativeLayout.LayoutParams textViewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        verbNameTextView = new TextView(this);
        verbNameTextView.setText("Verb Name");
        verbNameTextView.setLayoutParams(textViewParams);

        relativeLayout.addView(verbNameTextView);
    }

    protected void setVerbNameTextView(String text) {
        verbNameTextView.setText(text);
    }
    public abstract void onClickActionButton (View view);


}
