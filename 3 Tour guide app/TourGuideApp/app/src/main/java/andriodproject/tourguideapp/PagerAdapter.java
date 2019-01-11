package andriodproject.tourguideapp;


/**
 * Created by Hanouf on 3/31/17.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {


    private static final int TabsNumber = 4;
    private Context mContext;

    public PagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext= context;
    }

    @Override
    public int getCount() {
        return TabsNumber;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TopSightsFragment();
            case 1:
                return new MallsFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new EventsFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.top_sights_category);
            case 1:
                return mContext.getString(R.string.malls_category);
            case 2:
                return mContext.getString(R.string.restaurants_category);
            case 3:
                return mContext.getString(R.string.events_category);
            default:
                return null;
        }
    }

}



