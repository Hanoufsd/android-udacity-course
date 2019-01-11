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

public class EventsFragment extends Fragment {

    public EventsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<CategoryItem> items = new ArrayList<CategoryItem>();
        items.add(new CategoryItem(R.string.event_1, R.string.event_1_description));
        items.add(new CategoryItem(R.string.event_2, R.string.event_2_description));
        items.add(new CategoryItem(R.string.event_3, R.string.event_3_description));
        items.add(new CategoryItem(R.string.event_4, R.string.event_4_description));
        items.add(new CategoryItem(R.string.event_5, R.string.event_5_description));

        CategoryItemAdaptor categoryItemAdapter = new CategoryItemAdaptor(getActivity(), items);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(categoryItemAdapter);

        return view;
    }
}
