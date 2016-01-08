package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowSMSActivity extends MainActivity {
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(listener);
        FLAG = true;

        TextView smsDate = (TextView) findViewById(R.id.smsDate);
        TextView originNum = (TextView) findViewById(R.id.originNum);
        TextView originText = (TextView) findViewById(R.id.originText);

        Intent smsIntent = getIntent();

        String originNumber = smsIntent.getStringExtra("originNum");
        String originDate = smsIntent.getStringExtra("smsDate");
        String originSmsText = smsIntent.getStringExtra("originText");
        setReplyNumber(originNumber);

        originNum.setText(originNumber);
        smsDate.setText(originDate);
        originText.setText(originSmsText);
    }

    Button.OnClickListener listener = new Button.OnClickListener()
    {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button2:
                    Intent mylntent = new Intent(ShowSMSActivity.this, Main2.class);
                    startActivity(mylntent);
                    break;
            }
        }
    };
}
