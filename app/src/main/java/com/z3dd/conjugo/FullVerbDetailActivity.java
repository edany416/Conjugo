package com.z3dd.conjugo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class FullVerbDetailActivity extends AppCompatActivity {

    private TextView verbNameTextView;
    private EditText verbNameEditText;
    private static int verbNameEditTextId;
    private static int verbNameTextViewId;

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
        textViewParams.addRule(RelativeLayout.ALIGN_END, R.id.definition_text_view);

        verbNameTextView = new TextView(this);
        verbNameEditText = new EditText(this);

        verbNameEditTextId = View.generateViewId();
        verbNameEditText.setId(verbNameEditTextId);
        verbNameTextViewId = View.generateViewId();

        verbNameTextView.setText("Verb Name");
        verbNameTextView.setLayoutParams(textViewParams);

        RelativeLayout.LayoutParams editTextViewParams =
                new RelativeLayout.LayoutParams(setWidthInDip(this, 100),
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        editTextViewParams.addRule(RelativeLayout.ALIGN_START, R.id.nos_text_view);

        verbNameEditText.setLayoutParams(editTextViewParams);
        verbNameEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(verbNameEditText, InputMethodManager.SHOW_IMPLICIT);

        relativeLayout.addView(verbNameTextView);
        relativeLayout.addView(verbNameEditText);
    }

    public int getVerbNameEditTextId(){
        return verbNameEditTextId;
    }
    protected void setActionButtonText(String text) {
        Button actionButton = (Button) findViewById(R.id.action_button);
        actionButton.setText(text);
    }

    protected void setUpButton(Boolean showUpButton, String upButtonText) {
        if (showUpButton) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
            getSupportActionBar().setTitle(upButtonText);
        }
    }

    public abstract void onClickActionButton (View view);

    private int setWidthInDip(Context context, int pixels) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }

}
