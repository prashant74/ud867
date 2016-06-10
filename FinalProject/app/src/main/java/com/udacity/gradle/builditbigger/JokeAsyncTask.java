package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import com.example.prashant.myandroidlibrary.JokeActivity;
import com.example.prashant.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import java.io.IOException;

/**
 * Created by prashant on 6/8/16.
 */
public class JokeAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
  private static MyApi myApiService = null;
  private Context context;

  @Override protected String doInBackground(Pair<Context, String>... params) {
    if (myApiService == null) {  // Only do this once
      MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
          .setRootUrl("https://buiditbigger.appspot.com/_ah/api/");
      // end options for devappserver

      myApiService = builder.build();
    }

    context = params[0].first;
    String name = params[0].second;

    try {
      return myApiService.sayHi(name).execute().getData();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override protected void onPostExecute(String joke) {
    Intent myIntent = new Intent(context, JokeActivity.class);
    myIntent.putExtra("JOKE", joke);
    context.startActivity(myIntent);
  }

  public JokeAsyncTask(Context context) {
    this.context = context;
  }
}