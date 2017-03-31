package com.example.mobility.activitytrainingexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mMessageEditText;
    private static final int TEXT_RESULT =1;
    TextView mReplyHeader,mReplyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = (EditText)findViewById(R.id.editText_main);
        mReplyHeader = (TextView)findViewById(R.id.text_header_reply);
        mReplyText = (TextView)findViewById(R.id.text_message_reply);
           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void launchSecondActivity(View view) {
        String message = mMessageEditText.getText().toString();
        Intent intentSend = new Intent(MainActivity.this,SecondActivity.class);
        intentSend.putExtra("EXTRA_MESSAGE",message);
        startActivityForResult(intentSend,TEXT_RESULT);
    }

   public void onActivityResult(int requestCode,int resultCode,Intent data){
      super.onActivityResult(requestCode,resultCode,data);
       if(requestCode == TEXT_RESULT){
           if(resultCode == RESULT_OK){
               String replymessage = data.getStringExtra("REPLY_TEXT");
               mReplyHeader.setVisibility(View.VISIBLE);
               mReplyText.setText(replymessage);
               mReplyText.setVisibility(View.VISIBLE);
           }
       }
   }
}
