package com.diegulog.randomuser.ui.profile

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.diegulog.randomuser.databinding.FragmentProfileBinding
import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.ui.base.BaseFragment
import com.diegulog.randomuser.ui.home.HomeFragmentDirections
import com.diegulog.randomuser.utils.load
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val profileViewModel: ProfileViewModel by viewModel()
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                profileViewModel.addContactToPhone(user)
            } else {
                showMessage("Permission is required to add the contact")
            }
        }

    private val user: User by lazy {
        navArgs<ProfileFragmentArgs>().value.user
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadUI()
        binding.addContact.setOnClickListener {
            if (isWriteContactPermissionGranted()) {
                profileViewModel.addContactToPhone(user)
                showMessage("Contact added successfully")
            } else {
                requestPermissionLauncher.launch(Manifest.permission.WRITE_CONTACTS)
            }
        }

        binding.showQr.setOnClickListener {
            val direction = ProfileFragmentDirections.actionProfileFragmentToQRBottomSheet(user)
            Navigation.findNavController(view).navigate(direction)
        }
    }

    private fun loadUI() {
        binding.name.text = "${user.name.first} ${user.name.last}"
        binding.image.load(user.picture.large)
        binding.email.text = user.email
        binding.phone.text = user.phone
        binding.gender.text = user.gender
        binding.dob.text = user.dob.getDateFormat()
    }


    // check if permission is granted or not.
    private fun isWriteContactPermissionGranted(): Boolean {
        return requireActivity().checkPermission(
            Manifest.permission.WRITE_CONTACTS,
            Process.myPid(),
            Process.myUid()
        ) == PackageManager.PERMISSION_GRANTED
    }

}