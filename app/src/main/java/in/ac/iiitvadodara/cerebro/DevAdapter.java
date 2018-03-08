package in.ac.iiitvadodara.cerebro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.ac.iiitvadodara.cerebro.Models.Dev;
import in.ac.iiitvadodara.cerebro.YoYo.EventN;

public class DevAdapter extends ArrayAdapter<Dev> {

    public DevAdapter(Context context, List<Dev> devs) {
        super(context, 0, devs);
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.developer_item, parent, false);
        }

        final Dev currentPosition = getItem(position);

        TextView name = listItemView.findViewById(R.id.dev_name);
        ImageView img = listItemView.findViewById(R.id.dev_img);
        TextView phone = listItemView.findViewById(R.id.dev_phone);

        name.setText(currentPosition.getName());
        phone.setText(currentPosition.getPhone());
        if(currentPosition.getImg()!=null){
            Glide.with(getContext()).load(currentPosition.getImg()).into(img);
        }

        return listItemView;
    }
}
