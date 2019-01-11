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

public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<CategoryItem> items = new ArrayList<CategoryItem>();
        items.add(new CategoryItem(R.string.res_1));
        items.add(new CategoryItem(R.string.res_2));
        items.add(new CategoryItem(R.string.res_3));
        items.add(new CategoryItem(R.string.res_4));
        items.add(new CategoryItem(R.string.res_5));

        CategoryItemAdaptor categoryItemAdapter = new CategoryItemAdaptor(getActivity(), items);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(categoryItemAdapter);

        return view;
    }
}
