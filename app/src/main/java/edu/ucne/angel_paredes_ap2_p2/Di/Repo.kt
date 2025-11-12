package edu.ucne.angel_paredes_ap2_p2.Di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.angel_paredes_ap2_p2.Domain.Repository.GastoRepository
import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Repository.GastoRepositoryImpl
import javax.inject.Singleton

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class RepositoryModule {

        @Binds
        @Singleton
        abstract fun bindGastoRepository(
            impl: GastoRepositoryImpl
        ): GastoRepository
    }