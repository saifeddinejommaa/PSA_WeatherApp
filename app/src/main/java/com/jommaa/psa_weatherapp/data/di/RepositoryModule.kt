package com.jommaa.psa_weatherapp.data.di


import com.jommaa.psa_weatherapp.data.repositoriesImp.TownRepositoryImp
import com.jommaa.psa_weatherapp.data.repositoriesImp.WeatherRepositoryImp
import com.jommaa.psa_weatherapp.domain.repository.IWeatherRepository
import com.jommaa.psa_weatherappapplication.domain.repository.ITownRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class  RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTownRepository(albumsRepositoryImp: TownRepositoryImp): ITownRepository

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImp: WeatherRepositoryImp): IWeatherRepository
}
