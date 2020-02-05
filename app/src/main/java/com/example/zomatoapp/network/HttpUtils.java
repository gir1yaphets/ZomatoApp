package com.example.zomatoapp.network;

import android.content.Context;
import android.util.Log;

import com.example.zomatoapp.ZomatoApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.zomatoapp.utils.StaticValues.BASE_URL;
import static com.example.zomatoapp.utils.StaticValues.USER_KEY;
import static com.example.zomatoapp.utils.StaticValues.USER_KEY_VALUE;

public class HttpUtils {
    public static final String TAG = HttpUtils.class.getSimpleName();

    private static Map<String, Retrofit> retrofits = new HashMap<>();

    private static OkHttpClient getOKHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor((message -> Log.d(TAG, "log: message = " + message)));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);

        builder.addInterceptor((chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader(USER_KEY, USER_KEY_VALUE)
                    .build();
            return chain.proceed(request);
        }));
        return builder.build();
    }

    private static Retrofit getRetrofit(String baseUrl) {
        return getRetrofitWithContext(null, baseUrl);
    }

    /**
     * Please note that, the baseUrl of this Retrofit instance may be changed by different component
     * before you execute your API call. Create your own Retrofit instance if necessary.
     *
     * @param context enable cache and thus enable eTag for metadata
     * @param baseUrl The base url for Retrofit instance
     * @return Return the Retrofit instance with custom settings
     */
    private static Retrofit getRetrofitWithContext(Context context, String baseUrl) {
        return getRetrofitWithContext(context, baseUrl, false, true);
    }

    private static Retrofit getRetrofitWithContext(Context context, String baseUrl, boolean refreshSupport, boolean withCache) {
        if (!retrofits.containsKey(baseUrl)) {
            synchronized (Retrofit.class) {
//                OkHttpClient loggingClient = getHttpClientWithRefreshTokenSupport(context, refreshSupport, withCache);
                OkHttpClient loggingClient = getOKHttpClient();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(loggingClient)
                        .build();
                retrofits.put(baseUrl, retrofit);
            }
        }
        return retrofits.get(baseUrl);
    }

    public static Retrofit getApiGatewayRetrofit() {
        return getRetrofitWithContext(
                ZomatoApplication.getContext(),
                BASE_URL,
                true,
                true
        );
    }
}
