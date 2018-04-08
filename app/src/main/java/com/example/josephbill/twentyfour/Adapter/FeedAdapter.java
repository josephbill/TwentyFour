package com.example.josephbill.twentyfour.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josephbill.twentyfour.Interface.ItemClickListener;
import com.example.josephbill.twentyfour.R;
import com.example.josephbill.twentyfour.model.Rssobject;

/**
 * Created by Joseph Bill on 2/15/2018.
 */

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener{


    public TextView txtTitle, txtPubDate , txtContent;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);

        txtTitle = (TextView) itemView.findViewById(R.id.txttitle);
        txtPubDate = (TextView) itemView.findViewById(R.id.txtpubdate);
        txtContent = (TextView) itemView.findViewById(R.id.txtcont);

        //set event\

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

   public void setItemClickListener (ItemClickListener itemClickListener){

       this.itemClickListener = itemClickListener;
   }




    @Override
    public void onClick(View v) {
       itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}


public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {


    private Rssobject Rssobject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter ( Rssobject Rssobject , Context mContext){
        this.Rssobject = Rssobject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);



    }
    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
         holder.txtTitle.setText(Rssobject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(Rssobject.getItems().get(position).getPubDate());
        holder.txtContent.setText(Rssobject.getItems().get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return Rssobject.items.size();
    }
}
