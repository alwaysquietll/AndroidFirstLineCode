package com.example.jack.activitytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is " + getTaskId());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this, "You clicked Button 1",
                //        Toast.LENGTH_SHORT).show();
                //显式Intent
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //隐式Intetnt
                //Intent intent = new Intent("com.example.jack.activitytest.ACTION_START");
                //intent.addCategory("com.example.jack.activitytest.MY_CATEGORY");
                //通过Intent启动浏览器
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //通过Intent拨打电话
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //通过Intent传递数据
                //String data = "Hello SecondActivity";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //intent.putExtra("extra_data", data);
                //通过Intent获取返回的数据
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivityForResult(intent, 1);
                //singleTop模式
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                //startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart: ");
    }

}
