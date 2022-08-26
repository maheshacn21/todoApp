package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class todayFragment extends Fragment implements Serializable {


    public todayFragment() {
        // Required empty public constructor
    }

    ArrayList<PostPojo> arrdata1=new ArrayList<>();
    ArrayList<PostPojo> arrdata2=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_today, container, false);

        TextView txt=view.findViewById(R.id.textView2);
        TextView txt4=view.findViewById(R.id.textView4);
        RecyclerView recyclerViewTC=view.findViewById(R.id.recyclerViewTC);
        RecyclerView recyclerViewTP=view.findViewById(R.id.recyclerViewTP);

        //**************APIdata*******************************************************

       ApiInterface apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        apiInterface.getposts().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {

                if(response.body().size()>0){
                    arrdata1= (ArrayList<PostPojo>) response.body();
                    for(int i=0;i<arrdata1.size();i++){
                        if(arrdata1.get(i).getStatus().equalsIgnoreCase("completed")){
                            arrdata2.add(arrdata1.get(i));
                            arrdata1.remove(i);
                            i--;
                        }
                    }

                    Bundle bundle=new Bundle();
                    bundle.putString("key","hello");
                    laterFragment fragment= new laterFragment();
                    fragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().commit();

                    RecyclerAdapter adapter=new RecyclerAdapter(view.getContext(), arrdata1, new RecyclerAdapter.ItemClickListener() {
                        @Override
                        public void onItemClick(PostPojo details) {
                            System.out.println("item clicked");
                        }
                    });
                    RecyclerAdapter adapter1=new RecyclerAdapter(view.getContext(), arrdata2, new RecyclerAdapter.ItemClickListener() {
                        @Override
                        public void onItemClick(PostPojo details) {

                        }

                    });
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
                    LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(view.getContext());
                    recyclerViewTC.setLayoutManager(linearLayoutManager);
                    recyclerViewTP.setLayoutManager(linearLayoutManager1);
                    recyclerViewTP.setAdapter(adapter1);
                    recyclerViewTC.setAdapter(adapter);

                }
                else{
                    System.out.println("list is empty");
                }

                txt.setText(arrdata1.get(0).getScheduledDate().substring(6,8));
                txt4.setText("There's a lot going on today. There are "+arrdata1.size()+" todos\n scheduled and the first one starts at "+getTime(arrdata1.get(0).getScheduledDate()));

            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                System.out.println("connection failed");
            }
        });

        return view;
    }




    public String getTime(String s){
        String time="";
        String data=s.substring(8);
        Integer t=Integer.parseInt(data.substring(0,2));
        Integer m=Integer.parseInt(data.substring(2));

        if(t==00){
            if(m>0){
                if(m<=9){
                    time="12:0"+m+" AM";
                }
                else{
                    time="12:"+m+" AM";
                }
            }

            else{
                time="12 AM";
            }
        }

        else if(t==12){
            if(m>0){
                if(m<=9){
                    time="12:0"+m+" PM";
                }
                else{
                    time="12:"+m+" PM";
                }
            }
            else{
                time="12 PM";
            }
        }

        else if(t>12){
            if(m>0){
                if(m<=9){

                    time=(t-12)+":0"+m+" PM";
                }
                else{
                    time=(t-12)+":"+m+" PM";
                }
            }
            else{
                time=t-12+" PM";
            }
        }

        else{
            if(m>0){
                if(m<=9){

                    time=t+":0"+m+" AM";
                }
                else{
                    time=t+":"+m+" AM";
                }
            }
            time=t+" AM";
        }

        return time;
    }

}