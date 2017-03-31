package com.example.mobility.activitytrainingexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText mReplyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReplyText = (EditText)findViewById(R.id.editText_second);

        Intent intent= getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        TextView mRecievedText = (TextView)findViewById(R.id.text_message);
        mRecievedText.setText(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void returnReply(View view) {
        String message = mReplyText.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_TEXT",message);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
