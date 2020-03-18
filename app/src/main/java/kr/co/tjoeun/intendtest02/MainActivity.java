package kr.co.tjoeun.intendtest02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

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

    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);
    }
}
