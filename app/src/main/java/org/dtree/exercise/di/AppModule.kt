package org.dtree.exercise.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.dtree.exercise.data.local.Database
import org.dtree.exercise.data.remote.Api
import org.dtree.exercise.data.repository.UserRepoImpl
import org.dtree.exercise.domain.repository.UserRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): Database = Room.databaseBuilder(
        context, Database::class.java, "user_db"
    ).build()

    @Provides
    @Singleton
    fun providesApi(): Api =
        Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)


    @Provides
    @Singleton
    fun provideRepo(db: Database, api: Api ):UserRepo = UserRepoImpl(api, db)

}