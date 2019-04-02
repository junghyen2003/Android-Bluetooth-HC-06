package com.namooplus.android_bluetooth_hc_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 메뉴 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bluetooth_search, menu);
        return true;
    }

    // 메뉴 선택 시 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.bluetooth_search_menu:
                // 블루투스 기기 다이얼로그 생성
                Toast.makeText(this, "블루투스 기기 다이얼로그 생성",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
