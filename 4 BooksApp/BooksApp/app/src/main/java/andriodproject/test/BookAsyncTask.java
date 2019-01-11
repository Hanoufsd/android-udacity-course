package andriodproject.test;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by Hanouf on 4/20/17.
 */

public class BookAsyncTask extends AsyncTask<String, Void, ArrayList<Result>> {

    public static final String GOOGLE_BOOKS_API_BASE_URL = "https://www.googleapis.com/books/v1/volumes?maxResults=20&q=";
    private final String LOG_TAG = BookAsyncTask.class.getSimpleName();

    @Override
    protected ArrayList<Result> doInBackground(String... strs) {
        if (strs.length == 0) {
            return null;
        }

        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        String jsonResponse = null;

        try {

            URL url = new URL(GOOGLE_BOOKS_API_BASE_URL + strs[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            jsonResponse = buffer.toString();

        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, e.getMessage(), e);
                    e.printStackTrace();
                }
            }
        }
        try {

            return extractDataFromJson(jsonResponse);

        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<Result> extractDataFromJson(String bookJSON) throws JSONException {

        JSONObject baseJsonResponse = new JSONObject(bookJSON);
        JSONArray itemsArray = baseJsonResponse.getJSONArray("items");
        ArrayList<Result> result = new ArrayList<Result>();

        for (int i = 0; i < itemsArray.length(); i++) {

            JSONObject bookList = itemsArray.getJSONObject(i);
            JSONObject volInfo = bookList.getJSONObject("volumeInfo");
            String title = volInfo.getString("title");
            String author = "NA";

            JSONArray authors = volInfo.optJSONArray("authors");
            if (authors != null) {
                authors = volInfo.getJSONArray("authors");
                author = authors.getString(0);
                if (authors.length() > 1) {
                    for (int j = 1; j < authors.length(); j++)
                        author = author + " - " + authors.getString(j);
                }
            }
            result.add(new Result(title, author));
        }
        return result;
    }
}
