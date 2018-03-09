package in.ac.iiitvadodara.cerebro;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements View.OnClickListener{


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_about_us, container, false);

        ImageView pres = root.findViewById(R.id.pres);
        ImageView vp1 = root.findViewById(R.id.vpres1);
        ImageView vp2 = root.findViewById(R.id.vpres2);
        TextView ct = root.findViewById(R.id.core_team);
        TextView dt = root.findViewById(R.id.design_team);
        TextView at = root.findViewById(R.id.android_team);
        TextView wt = root.findViewById(R.id.web_team);

        ct.setOnClickListener(this);
        dt.setOnClickListener(this);
        at.setOnClickListener(this);
        wt.setOnClickListener(this);

        pres.setImageResource(R.drawable.cerebro1);
        vp1.setImageResource(R.drawable.cerebro1);
        vp2.setImageResource(R.drawable.cerebro1);
        Glide.with(this).load("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAMAAQDGAAwAAQAAAAAAAA1RAAAAJDUyMWRmMDY4LTRmYzEtNDViNy1iODNmLWRjODQxNTRkMzY3ZQ.jpg").into(pres);
        Glide.with(this).load("https://pbs.twimg.com/profile_images/940141703293308928/3Mm3bnm9.jpg").into(vp1);
        Glide.with(this).load("https://avatars1.githubusercontent.com/u/21199234?s=400&v=4").into(vp2);

        return root;
    }

    @Override
    public void onClick(View v) {
        String url = "https://cerebro.iiitv.ac.in/about";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
