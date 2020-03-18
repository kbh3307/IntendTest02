package kr.co.tjoeun.intendtest02.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.tjoeun.intendtest02.R;
import kr.co.tjoeun.intendtest02.datas.Room;

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
        if(row == null){
            row = inf.inflate(R.layout.room_list_item, null);
        }

        Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.addressAndFloorTxt);
        TextView decriptionTxt = row.findViewById(R.id.decriptionTxt);

//        가격 설정 => setText에는 int 값 넣지 말자.
//            1만 이상? 억 단위, 아니면? 숫자만 , 찍어서

        priceTxt.setText(data.getFormattedPrice());

        addressAndFloorTxt.setText(String.format("%s, %s", data.getAddress(), data.getFloorToString()));

//        설명은 들어온 그대로 출력
        decriptionTxt.setText(data.getDescription());
       return row;
    }
}
