package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by prashant on 6/8/16.
 */
public class MyJokeTest extends AndroidTestCase {
  public void runCloudModuleTest() {
    String joke = null;
    JokeAsyncTask jokesAsyncTask = new JokeAsyncTask(getContext());
    jokesAsyncTask.execute(new Pair<Context, String>(getContext(), "Manfred"));
    try {
      joke = jokesAsyncTask.get();
      Log.d("CloudModuleTest", "Retrieved a non-empty string successfully: " + joke);
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertNotNull(joke);
  }
}
