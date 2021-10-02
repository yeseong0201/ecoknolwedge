package com.example.ecoknowledge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.ecoknowledge.ListModel;
import com.example.ecoknowledge.R;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<ListModel> {

    private ArrayList<ListModel> objects;

    public ListAdapter(Context context, int textViewResourceId, ArrayList<ListModel> qUESTIONS)
    {
        super(context, textViewResourceId, qUESTIONS);
        objects = qUESTIONS;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;


            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_row, null);

            TextView txtqstn =  v.findViewById(R.id.txtQSTN);
            TextView txtselectedANS =  v.findViewById(R.id.txtSelectedANS);
            TextView txtactualANS =  v.findViewById(R.id.txtActualANS);

            txtqstn.setText("문제: " + objects.get(position).getQuestion());
            txtselectedANS.setText("X 내가 고른 정답 : " + objects.get(position).getSelectedAnswer());
            txtactualANS.setText("O 실제 정답 : " + objects.get(position).getActualAnswer());

        return v;
    }
}
