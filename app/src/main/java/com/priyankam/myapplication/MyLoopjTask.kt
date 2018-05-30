package com.priyankam.myapplication

import android.content.Context
import android.util.Log
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MyLoopjTask constructor(mContext: Context, listener: OnLoopjCompleted) {

    internal var asyncHttpClient: AsyncHttpClient
    internal var requestParams: RequestParams

    internal var BASE_URL = "http://www.omdbapi.com/?"
    internal var BASE_URL_MOCKY = "http://www.mocky.io/v2/5b0d433a3100004d009d55cd"

    lateinit var jsonResponse: String
    var context: Context
    var loopjListener: OnLoopjCompleted


    companion object {
        private val TAG = "MOVIE _TRIVIA"
    }

    init {
        asyncHttpClient = AsyncHttpClient()
        requestParams = RequestParams()
        context = mContext
        loopjListener = listener


    }

    fun executeLoopjCall(queryTerm: String) {

        //add header in url
        requestParams.put("s", queryTerm)
        requestParams.put("apikey", "5a2eb90f") // your own API key generate in this "http://www.omdbapi.com/?"

        asyncHttpClient.get(BASE_URL, requestParams, object : JsonHttpResponseHandler() {

            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                super.onSuccess(statusCode, headers, response)
                jsonResponse = response.toString()
                loopjListener.taskCompleted(jsonResponse)
                Log.i(TAG, "onSuccess: " + jsonResponse)
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, errorResponse: JSONObject) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                loopjListener.taskCompleted(errorResponse.toString())
                Log.e(TAG, "onFailure: " + errorResponse)
            }

        }
        );
    }

    fun executeLoopjCall() {
        try {
            //add header in url
            requestParams.put("apikey", "5a2eb90f") // your own API key generate in this "http://www.omdbapi.com/?"

            asyncHttpClient.get(BASE_URL_MOCKY, requestParams, object : JsonHttpResponseHandler() {



                override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                    super.onSuccess(statusCode, headers, response)
                    jsonResponse = response.toString()
                    loopjListener.taskCompleted(jsonResponse)
                    Log.i(TAG, "onSuccess: " + jsonResponse)
                }

                override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, errorResponse: JSONObject) {
                    super.onFailure(statusCode, headers, throwable, errorResponse)
                    loopjListener.taskCompleted(errorResponse.toString())
                    Log.e(TAG, "onFailure: " + errorResponse)
                }

            }
            );
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}
