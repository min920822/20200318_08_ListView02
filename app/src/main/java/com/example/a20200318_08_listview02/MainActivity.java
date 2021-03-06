package com.example.a20200318_08_listview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ListChangeRegistry;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.a20200318_08_listview02.adapter.RoomAdapter;
import com.example.a20200318_08_listview02.databinding.ActivityMainBinding;
import com.example.a20200318_08_listview02.datas.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding = null;

    List<Room> roomDatas = new ArrayList<>();

    RoomAdapter roomAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();

    }


    @Override
    public void setupEvents() {

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("리스트뷰 아이템 클릭", String.format("%d번 줄 클릭", position));

//                클릭된 방의 주소를 Toast로 출력

                Room ClickedRoom = roomDatas.get(position);

                Intent intent = new Intent(mContext,RoomDetailActivity.class);
                intent.putExtra("room", ClickedRoom);
                startActivity(intent);

                Toast.makeText(mContext, ClickedRoom.getAddress(), Toast.LENGTH_SHORT).show();

            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override

            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Room data = roomDatas.get(position);
                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

                return true;

            }
        });

    }

    @Override
    public void setValues() {

        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);

        binding.roomListView.setAdapter(roomAdapter);

        addRoom();

    }

        void addRoom() {

            roomDatas.add(new Room(8000,"서울시 종로구",4,"종로구 투룸"));
            roomDatas.add(new Room(28500,"서울시 은평구",2,"은평구 쓰리룸"));
            roomDatas.add(new Room(28500,"경기도 부천시",1,"부천시 단독주택"));
            roomDatas.add(new Room(7000,"경기도 고양시",0,"고양시 원룸"));
            roomDatas.add(new Room(8000,"서울시 노원구",-1,"살기 좋은 방입니다."));


        roomAdapter.notifyDataSetChanged();
    }
}
