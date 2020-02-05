package com.example.zomatoapp.network;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Response;

public class RetrofitApiCallback<T> extends BaseCallback<T> {

    private final int STATUS_CODE_400 = 400;
    private final int STATUS_CODE_500 = 500;

    private OnActionHandleListener mOnActionListener;
    private boolean mIsNeedSpecHandleError = false;

    public RetrofitApiCallback(OnActionHandleListener listener) {
        mOnActionListener = listener;
    }

    @Override
    public void onServiceResponse(Call<T> call, Response<T> response) {
        if (mOnActionListener != null) {
            try {
                mOnActionListener.onBeforeHandling();
                if (response != null) {
                    if (response.isSuccessful()) {
                        //handle 200
                        if (response.body() == null) {
                            //body == null means the response can not be parsed into <T>
                            throw new Throwable("failed to parse the response");
                        } else {
                            mOnActionListener.onSuccess(response);
                            return;
                        }
                    } else {
                        RetrofitErrorModel mError = null;

                        mError = new Gson().fromJson(response.errorBody().string(), RetrofitErrorModel.class);
                        if (mError != null && mError.getErrors() != null && mError.getErrors().size() > 0) {
                            switch (response.code()) {
                                case STATUS_CODE_500:
                                    //generic error
                                    mOnActionListener.onError(mError);
                                    break;
                                case STATUS_CODE_400:
                                    throw new Throwable("technical error");
                                default:
                                    mOnActionListener.onError(new RetrofitErrorModel());
                            }
                        } else {
                            throw new Throwable("failed to parse the error body");
                        }
                    }
                } else {
                    throw new Throwable("response is null");
                }
            } catch (Throwable t) {
                mOnActionListener.onTechIssueError(t);
            }
        } else {
            IllegalArgumentException e =  new IllegalArgumentException("please init OnErrorListener");
            throw e;
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (mOnActionListener != null) {
            mOnActionListener.onBeforeHandling();
            mOnActionListener.onTechIssueError(t);
        } else {
            IllegalArgumentException e =  new IllegalArgumentException("please init OnErrorListener");
            throw e;
        }
    }

    public interface OnActionHandleListener<T> {
        /**
         * extra method for hiding loading dialog or any UI update
         */
        void onBeforeHandling();

        void onSuccess(Response<T> response);

        void onError(RetrofitErrorModel errors);

        void onTechIssueError(Throwable t);
    }
}
