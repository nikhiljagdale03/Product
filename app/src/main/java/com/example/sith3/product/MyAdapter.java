package com.example.sith3.product;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    protected Context mContext;
    private List<Product> mData;
    MyAdapter(Context context,List<Product> data){
        mContext=context;
        mData=data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_recy_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Product P=mData.get(position);
        holder.textView1.setText(P.getName());
        holder.textView3.setText(""+P.getQty());
        holder.textView2.setText(""+P.getUnitPrice());


        holder.minusb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition=holder.getAdapterPosition();
                Product p=mData.get(clickedPosition);
                int qty=p.getQty();
                if(qty>0){
                    p.setQty(qty-1);
                    notifyItemChanged(clickedPosition);
                }
            }
        });
        holder.plusb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPos=holder.getAdapterPosition();
                Product p=mData.get(clickedPos);
                int qty=p.getQty();
                p.setQty(qty+1);
                notifyItemChanged(clickedPos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        Button minusb1,plusb2;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.prod_Name);
            textView2=itemView.findViewById(R.id.price);
            textView3=itemView.findViewById(R.id.qty);
            minusb1=itemView.findViewById(R.id.minus);
            plusb2=itemView.findViewById(R.id.plus);
        }
    }
}
