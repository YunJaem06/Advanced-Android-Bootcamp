package com.anushka.didemo

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteyModule {

    @Binds
    abstract fun bindNCBattey(nickelCadmiumBattery: NickelCadmiumBattery) : Battery
}