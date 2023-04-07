package com.geektech.lovecalculator.ui.di

import android.content.Context
import com.geektech.lovecalculator.data.Pref
import com.geektech.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun  provideApi():LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(LoveApi::class.java)
    }

        @Provides
        fun SharedPreferences(@ApplicationContext context: Context): Pref {
        return Pref((context))

    }


}
