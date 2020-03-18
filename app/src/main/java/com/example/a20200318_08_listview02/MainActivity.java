package com.example.a20200318_08_listview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ListChangeRegistry;

import android.os.Bundle;

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



    }

    @Override
    public void setValues() {

        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);

        binding.roomListView.setAdapter(roomAdapter);

        addRoom();


    }

        void addRoom() {

            roomDatas.add(new Room(8000,"서울시 종로구",4,"종로구 투룸"));
            roomDatas.add(new Room(8000,"서울시 은평구",2,"은평구 쓰리룸"));
            roomDatas.add(new Room(8000,"경기도 부천시",1,"부천시 단독주택"));
            roomDatas.add(new Room(8000,"경기도 고양시",0,"고양시 원룸"));
            roomDatas.add(new Room(8000,"서울시 노원구",-1,"살기 좋은 방입니다."));


        roomAdapter.notifyDataSetChanged();
    }
}
