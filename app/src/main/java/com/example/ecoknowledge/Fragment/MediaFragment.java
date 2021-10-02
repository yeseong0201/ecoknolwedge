package com.example.ecoknowledge.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ecoknowledge.Adapter.MediaAdapter;
import com.example.ecoknowledge.MediaItem;
import com.example.ecoknowledge.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class MediaFragment extends Fragment {

    private RecyclerView recycler_media;
    private ArrayList<MediaItem> list = new ArrayList();
    private SwipeRefreshLayout refreshLayout;


    public MediaFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (isConnected != true) {
            Toast.makeText(getActivity().getApplicationContext(), "인터넷 연결 후 다시 시도해주세요. ", Toast.LENGTH_SHORT).show();
        }


        View v = inflater.inflate(R.layout.fragment_media, container, false);

        recycler_media = v.findViewById(R.id.recycler_media);
        refreshLayout = v.findViewById(R.id.swipe_refresh_layout);

        refreshLayout.setColorSchemeColors(Color.parseColor("#92e1b3"));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


//                description.doInBackground();

                //ArraList를 인자로 해서 어답터와 연결한다.
                MediaAdapter myAdapter = new MediaAdapter(list);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                recycler_media.setLayoutManager(layoutManager);
                recycler_media.setAdapter(myAdapter);


                refreshLayout.setRefreshing(false);

            }
        });

        new Description().execute();


        return v;
    }

    private class Description extends AsyncTask<Void, Void, Void> {

        //진행바표시
        private ProgressDialog progressDialog;

        @Override
        public void onPreExecute() {
            super.onPreExecute();

            //진행다일로그 시작
            progressDialog = new ProgressDialog(getContext()); // 여기
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("기사를 불러오는 중입니다.");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                // 크롤링 규칙!!! html 가져올 때 클래스는 . id는 #으로 가져온다.

                Document doc = Jsoup.connect("http://www.hkisnews.com/sub.html?section=sc1").get();
                Elements mElementDataSize = doc.select("#sub_read_list").select("div.sub_read_list_box"); //필요한 녀석만 꼬집어서 지정
                int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다. 그만큼 루프를 돌려야 하나깐.
                Log.d("elesize", "사이즈" + mElementSize);

                for (Element elem : mElementDataSize) { //이렇게 요긴한 기능이

                    String title_news = elem.select("div.sub_read_list_box dl dt a").text();
                    String content_news = elem.select("dd.sbody a").text();
                    String image_news = elem.select("div.img_file p a img").attr("src");
                    String link_news = elem.select("div.img_file a").attr("href");

                    list.add(new MediaItem(title_news, "http://www.hkisnews.com/" + image_news, content_news,
                            "http://www.hkisnews.com" + link_news));

                    Log.d("title", "타이틀: " + title_news);
                    Log.d("image", "이미지 src: " + image_news);
                    Log.d("link", "링크 :" + link_news);
                }

                //추출한 전체 <li> 출력해 보자.
                Log.d("debug :", "List " + mElementDataSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //ArraList를 인자로 해서 어답터와 연결한다.
            MediaAdapter myAdapter = new MediaAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recycler_media.setLayoutManager(layoutManager);
            recycler_media.setAdapter(myAdapter);

            progressDialog.dismiss();
        }
    }


}