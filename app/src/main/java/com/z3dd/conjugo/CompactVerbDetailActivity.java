package com.z3dd.conjugo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
public abstract class CompactVerbDetailActivity extends AppCompatActivity {

    private TextView verbNameTextView;
    private static int verbNameTextViewId;
    private static boolean verbSetWasEmpty;

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
        verbNameTextViewId = View.generateViewId();
        verbNameTextView.setId(verbNameTextViewId);
        verbNameTextView.setText("Verb Name");
        verbNameTextView.setLayoutParams(textViewParams);

        relativeLayout.addView(verbNameTextView);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (VerbSetManager.setHasVerb()) {
            TextView textView = (TextView) findViewById(verbNameTextViewId);
            textView.findViewById(verbNameTextViewId).setVisibility(View.VISIBLE);
        }
    }

    protected void setVerbNameTextView(String text) {
        verbNameTextView.setText(text);
    }
    protected void setActionButtonText(String text) {
        Button actionButton = (Button) findViewById(R.id.action_button);
        actionButton.setText(text);
    }
    protected void hideVerbNameTextView() {
        TextView textView = (TextView) findViewById(verbNameTextViewId);
        textView.findViewById(verbNameTextViewId).setVisibility(View.GONE);
    }
    public abstract void onClickActionButton (View view);


}
