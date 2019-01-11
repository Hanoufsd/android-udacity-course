package andriodproject.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Result>> {

    private static final String NEWS_REQUEST_URL =
            "http://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test&page-size=20&show-tags=contributor";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int LOADER_ID = 1;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
        ListView listView = (ListView) findViewById(R.id.list_view);
        adapter = new NewsAdapter(this, new ArrayList<Result>());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Result currentRow = adapter.getItem(i);

                Uri newsUri = Uri.parse(currentRow.getWebURL());
                Log.d(LOG_TAG, newsUri.toString());

                if (currentRow.getWebURL() == null || TextUtils.isEmpty(currentRow.getWebURL())) {
                    Toast.makeText(MainActivity.this, "There is No URL", Toast.LENGTH_SHORT).show();
                } else {
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                    startActivity(websiteIntent);
                }
            }
        });


    }

    @Override
    public Loader<List<Result>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(this, NEWS_REQUEST_URL);
    }


    @Override
    public void onLoadFinished(Loader<List<Result>> loader, List<Result> results) {
        adapter.clear();

        if (results != null && !results.isEmpty()) {
            adapter.addAll(results);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Result>> loader) {
        adapter.clear();
    }


}
