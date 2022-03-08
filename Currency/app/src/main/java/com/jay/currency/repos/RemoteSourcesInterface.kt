package com.jay.currency.repos


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jay.currency.BuildConfig
import com.jay.currency.Const
import com.jay.currency.data_model.CurrencyRateResponse
import com.jay.currency.data_model.SupportCurrencyResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteSourcesInterface {

    companion object {


        fun create() : RemoteSourcesInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builderHttpClient())
                .baseUrl(Const.BASE_URL)
                .build()

            return retrofit.create(RemoteSourcesInterface::class.java)
        }

        private fun builderHttpClient() : OkHttpClient {
            val client = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(logging)
            }
            return client.build()
        }
    }


    @GET("live")
    suspend fun getCurrencyRateList(@Query("access_key") key : String) : Response<CurrencyRateResponse>

    @GET("list")
    suspend fun getSupportedCurrency( @Query("access_key") key : String) : Response<SupportCurrencyResponse>

}