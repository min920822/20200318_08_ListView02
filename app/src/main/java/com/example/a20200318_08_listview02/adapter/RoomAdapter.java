package com.example.a20200318_08_listview02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a20200318_08_listview02.R;
import com.example.a20200318_08_listview02.datas.Room;

import java.util.List;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.room_list_item,null);
        }

        Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTx = row.findViewById(R.id.priceTxt);
        TextView descTxt = row.findViewById(R.id.priceTxt);

//        가격설정. => setText에는 int값 넣지 말자.

        if ( data.getPrice()>=10000){
//            ?억 %,d로 가공
//            ?억 %,d
            int billion = data.getPrice() / 10000;
            int thousand = data.getPrice() % 10000;

            priceTxt.setText(String.format("%d억 %,d",billion,thousand));
        }
        else{
            priceTxt.setText(String.format("%,d",data.getPrice()));
        }

        return row;


    }
}
