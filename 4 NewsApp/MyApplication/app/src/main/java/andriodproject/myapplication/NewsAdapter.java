package andriodproject.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hanouf on 4/28/17.
 */

public class NewsAdapter extends ArrayAdapter<Result> {


    public NewsAdapter(Context context, ArrayList<Result> arrayList) {
        super(context, 0, arrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Result currentNews = getItem(position);

        TextView title = (TextView) convertView.findViewById(R.id.title_txt);
        TextView section = (TextView) convertView.findViewById(R.id.section_txt);

        title.setText(currentNews.getTitle());
        section.setText(currentNews.getSection());

        return convertView;
    }

}
