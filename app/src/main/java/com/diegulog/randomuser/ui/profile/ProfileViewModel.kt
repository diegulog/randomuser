package com.diegulog.randomuser.ui.profile

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.utils.ContactManager

class ProfileViewModel(
    private val contactManager: ContactManager
) : ViewModel() {

    fun addContactToPhone(user: User): Boolean {
        return contactManager.addContact(user)
    }

    fun generateQRCode(user: User): Bitmap {
        return contactManager.generateQRCode(user)
    }

}