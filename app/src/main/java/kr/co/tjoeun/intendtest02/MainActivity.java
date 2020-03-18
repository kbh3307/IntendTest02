package kr.co.tjoeun.intendtest02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.intendtest02.adapters.RoomAdapter;
import kr.co.tjoeun.intendtest02.databinding.ActivityMainBinding;
import kr.co.tjoeun.intendtest02.datas.Room;

public class MainActivity extends BaseActivity {

    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("리스트뷰 아이템 클릭", String.format("%d번 줄 클릭", position));

//                클릭된 방의 정보를 목록에서 빼옴 position번째

                Room clickedRoom = roomDatas.get(position);

//                방 상세 화면으로 이동
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);

            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                꾹 누르고 있으면, 해당 방의 설명을 Toast로 출력

                Room data = roomDatas.get(position);


                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

                return true; // true : 롱클릭만 false : 그냥 클릭도 같이
            }
        });

    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);

        addRoom();
    }

    private void addRoom() {
        roomDatas.add(new Room(8000,"서울시 은평구", 4, "살기 좋은 방입니다."));
        roomDatas.add(new Room(7000,"서울시 노원구", 2, "서울치고 쌉니다."));
        roomDatas.add(new Room(3000,"인천시 부평구", -1, "사지마세요."));
        roomDatas.add(new Room(5000,"경기도 고양시", 0, "고양이 많아요."));
        roomDatas.add(new Room(18000,"경기도 부천시", 5, "가격이 많이 비쌉니다."));

        roomAdapter.notifyDataSetChanged();
    }

}
