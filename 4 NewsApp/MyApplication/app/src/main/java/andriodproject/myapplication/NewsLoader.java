package andriodproject.myapplication;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

/**
 * Created by Hanouf on 4/28/17.
 */

public class NewsLoader extends AsyncTaskLoader<List<Result>> {

    public static final String LOG_TAG = NewsLoader.class.getSimpleName();

    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Result> loadInBackground() {

        Log.d(LOG_TAG, "loadInBackground...");
        if (mUrl == null) {
            return null;
        }

        List<Result> newsList = QueryUtils.fetchData(mUrl);

        return newsList;
    }


}
