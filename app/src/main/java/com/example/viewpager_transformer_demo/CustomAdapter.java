package com.example.viewpager_transformer_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.holder> {

   int images[]=new int[]{R.drawable.download,R.drawable.image_1,R.drawable.image_3,R.drawable.image_4,R.drawable.image_6,R.drawable.images_7,
          R.drawable.images_8,R.drawable.images_9,R.drawable.images_10,R.drawable.images_11,
           R.drawable.images_12,R.drawable.images_13,R.drawable.images_14,R.drawable.images_15,
           R.drawable.images_16,R.drawable.images_17,R.drawable.images_18,R.drawable.images_19,R.drawable.images_20,
           R.drawable.images_21,R.drawable.images_22,R.drawable.images_23,R.drawable.images_24,R.drawable.images_25};

   // int images[]=new int[]{R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};

    Context context;
    public CustomAdapter(Context context) {
        super();
        this.context=context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
         return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        holder.image.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class holder extends RecyclerView.ViewHolder{

        ImageView image;

        public holder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_view);

        }
    }
}
