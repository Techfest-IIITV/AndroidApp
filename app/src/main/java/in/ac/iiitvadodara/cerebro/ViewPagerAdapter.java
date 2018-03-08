package in.ac.iiitvadodara.cerebro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;

/**
 * Created by Dell on 25/02/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<EventN> gamingList, codingList;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<EventN> gamingList, ArrayList<EventN> codingList) {
        super(fm);
        this.gamingList = gamingList;
        this.codingList = codingList;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                bundle.putParcelableArrayList("eventList", codingList);
                CodingFragment fragment = new CodingFragment();
                fragment.setArguments(bundle);
                return fragment;
            case 1:
                bundle.putParcelableArrayList("eventList", gamingList);
                GamingFragment fragment2 = new GamingFragment();
                fragment2.setArguments(bundle);
                return fragment2;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "CODING";
            case 1:
                return "GAMING";
            default:
                return null;
        }
    }
}
