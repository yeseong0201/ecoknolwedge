package com.example.ecoknowledge.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ecoknowledge.Adapter.ChatAdapter;
import com.example.ecoknowledge.ChatData;
import com.example.ecoknowledge.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class EcomentFragment extends Fragment implements View.OnClickListener {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    // private ArrayAdapter<String> mAdapter;
    private EditText edtMessage;
    private ListView ecomentListview;
    private Button send_btn;
    private ChatAdapter chatAdapter;
    private String userName;
    private ImageView img;


    public EcomentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ecoment, container, false);


        edtMessage = v.findViewById(R.id.edt_comment);
        ecomentListview = v.findViewById(R.id.ecoment_listview);
        send_btn = v.findViewById(R.id.send_btn);
        img = v.findViewById(R.id.img_profile);

        chatAdapter = new ChatAdapter(getContext(), 0);
        ecomentListview.setAdapter(chatAdapter);
        send_btn.setOnClickListener(this);

        initFirebaseDatabase();
        initValues();


        return v;
    }

    private void initValues() {
        userName = "환경지킴이" + new Random().nextInt(1000);
    }

    private void initFirebaseDatabase() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("message");
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatData chatData = dataSnapshot.getValue(ChatData.class);
                chatData.firebaseKey = dataSnapshot.getKey();
                chatAdapter.add(chatData);
                ecomentListview.smoothScrollToPosition(chatAdapter.getCount());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String firebaseKey = dataSnapshot.getKey();
                int count = chatAdapter.getCount();
                for (int i = 0; i < count; i++) {
                    if (chatAdapter.getItem(i).firebaseKey.equals(firebaseKey)) {
                        chatAdapter.remove(chatAdapter
                                .getItem(i));
                        break;
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        mDatabaseReference.addChildEventListener(mChildEventListener);
    }


    @Override
    public void onClick(View view) {
        String message = edtMessage.getText().toString();
        if (!TextUtils.isEmpty(message)) {
            edtMessage.setText("");
            ChatData chatData = new ChatData();
            chatData.userName = userName;
            chatData.message = message;
            chatData.time = System.currentTimeMillis();
            mDatabaseReference.push().setValue(chatData);

        }
    }
}