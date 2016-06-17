package com.example.junekelectric.yoyofishing;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

    Intent intent = getIntent();
    int result = intent.getIntExtra("result", 0);

    TextView textView = (TextView) findViewById(R.id.textView);
    ImageView imageView = (ImageView) findViewById(R.id.imageView);

    switch (result) {
        case 0:
            textView.setText("残念とれませんでした。。。");
            // nullを入れるのは画像を表示しないから
            imageView.setImageDrawable(null);
            break;
        case 1:
            textView.setText("やった！\n1個取れたよ！");
            imageView.setImageResource(R.drawable.img_yoyo1);
            break;
        case 2:
            textView.setText("やった！\n2個取れたよ！！");
            imageView.setImageResource(R.drawable.img_yoyo2);
            break;
        case 3:
            textView.setText("すごい！\n3個取れたよ！！！");
            imageView.setImageResource(R.drawable.img_yoyo3);
            break;
        case 4:
        default:
            textView.setText("すごい！\nたくさん取れたよ！！！！");
            imageView.setImageResource(R.drawable.img_yoyo4);
            break;
    }
};


    public void retry(View view) {
        // 一つ前の画面に戻るからfinishを呼び出して、現在の画面を閉じる
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
}
