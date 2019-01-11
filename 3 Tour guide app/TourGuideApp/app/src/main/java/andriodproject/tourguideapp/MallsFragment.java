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

public class MallsFragment extends Fragment {
    public MallsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<CategoryItem> items = new ArrayList<CategoryItem>();
        items.add(new CategoryItem(R.string.mall_1,R.string.mall_1_address));
        items.add(new CategoryItem(R.string.mall_2,R.string.mall_2_address));
        items.add(new CategoryItem(R.string.mall_3,R.string.mall_3_address));
        items.add(new CategoryItem(R.string.mall_4,R.string.mall_4_address));
        items.add(new CategoryItem(R.string.mall_5,R.string.mall_5_address));


        CategoryItemAdaptor categoryItemAdapter = new CategoryItemAdaptor(getActivity(), items);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(categoryItemAdapter);

        return view;
    }

}
