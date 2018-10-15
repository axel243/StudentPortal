package com.example.axel.studentportal

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Portal internal constructor(private var portalUrl: String, private var title: String) : Serializable {

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun getPortalUrl(): String?{
        return portalUrl
    }

    fun setPortalUrl(portalUrl: String){
        this.portalUrl = portalUrl
    }

}
