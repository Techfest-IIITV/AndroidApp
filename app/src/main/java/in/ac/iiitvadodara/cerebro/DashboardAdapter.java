package in.ac.iiitvadodara.cerebro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;

/**
 * Created by harshendra on 28/2/18.
 */

public class DashboardAdapter extends ArrayAdapter<EventN> {

    public DashboardAdapter(Context context, List<EventN> events) {
        super(context, 0, events);
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item, parent, false);
        }

        final EventN currentPosition = getItem(position);

        ImageView eventIcon = (ImageView) listItemView.findViewById(R.id.image);
        if(currentPosition.getId() == 16){
            eventIcon.setImageResource(15);
        }else{
            eventIcon.setImageResource(currentPosition.getId());
        }
        eventIcon.setVisibility(View.VISIBLE);

        TextView eventName = (TextView) listItemView.findViewById(R.id.name) ;
        eventName.setText(currentPosition.getName());

        LinearLayout item = (LinearLayout) listItemView.findViewById(R.id.itemLinearLayout);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), currentPosition.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), EventInfoActivity.class);
//              i.putExtra();
                getContext().startActivity(i);
            }
        });

        TextView eventDescription = (TextView) listItemView.findViewById(R.id.description) ;
        eventDescription.setText(currentPosition.getDescription());
        return listItemView;
    }
}
