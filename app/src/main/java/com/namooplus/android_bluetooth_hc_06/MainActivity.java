package com.namooplus.android_bluetooth_hc_06;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    List<Map<String, Object>> dialogItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, Object> itemMap = new HashMap<>();
        itemMap.put("test1","test1");
        itemMap.put("test2","test2");
        dialogItemList.add(itemMap);
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
                //Toast.makeText(this, "블루투스 기기 다이얼로그 생성",Toast.LENGTH_SHORT).show();
                show_bluetooth_list_dialog();
                break;
        }
        return true;
    }

    // 블루투스 기기 다이얼로그
    private void show_bluetooth_list_dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.bluetooth_list_dialog,null);
        builder.setView(view);

        final ListView bluetooth_search_ListView = (ListView)view.findViewById(R.id.bluetooth_search_ListView);
        final AlertDialog dialog = builder.create();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,dialogItemList, R.layout.bluetooth_list_item, new String[]{"test1","test2"},new int[]{R.id.textView, R.id.textView2});

        bluetooth_search_ListView.setAdapter(simpleAdapter);
        bluetooth_search_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "아이템 클릭", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.bluetooth_search_SwipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(view.getContext(), "리스트 리프레시", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }
}
