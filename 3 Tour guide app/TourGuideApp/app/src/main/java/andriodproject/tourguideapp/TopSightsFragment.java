package andriodproject.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Hanouf on 3/31/17.
 */

public class TopSightsFragment extends Fragment {
    public TopSightsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<CategoryItem> items = new ArrayList<CategoryItem>();
        items.add(new CategoryItem(R.string.topSight_1,R.string.topSight_1_description,R.drawable.masmak_fort_1));
        items.add(new CategoryItem(R.string.topSight_2,R.string.topSight_2_description,R.drawable.national_museum_2));
        items.add(new CategoryItem(R.string.topSight_3,R.string.topSight_3_description,R.drawable.saqr_aljazira_3));
        items.add(new CategoryItem(R.string.topSight_4,R.string.topSight_4_description,R.drawable.salaam_park_4));
        items.add(new CategoryItem(R.string.topSight_5,R.string.topSight_5_description,R.drawable.zoo_5));

        CategoryItemAdaptor categoryItemAdapter = new CategoryItemAdaptor(getActivity(), items);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(categoryItemAdapter);

        return view;
    }
}
