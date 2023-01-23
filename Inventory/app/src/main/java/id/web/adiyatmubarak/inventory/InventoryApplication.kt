package id.web.adiyatmubarak.inventory

import android.app.Application
import id.web.adiyatmubarak.inventory.data.AppContainer
import id.web.adiyatmubarak.inventory.data.AppDataContainer

class InventoryApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}