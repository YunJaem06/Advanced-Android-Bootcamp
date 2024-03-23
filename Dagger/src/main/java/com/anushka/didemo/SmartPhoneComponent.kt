package com.anushka.didemo

import dagger.Component

@Component(modules = [MemoryCardModule::class, NCBatteyModule::class])
interface SmartPhoneComponent {

    fun getSmartPhone() : SmartPhone
}