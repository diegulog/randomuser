package com.diegulog.randomuser.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.diegulog.randomuser.databinding.QrBottomSheetContentBinding
import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.utils.load
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class QRBottomSheet : BottomSheetDialogFragment() {
    private val profileViewModel: ProfileViewModel by viewModel()
    private var _binding: QrBottomSheetContentBinding? = null
    private val binding get() = _binding!!

    private val user: User by lazy {
        navArgs<ProfileFragmentArgs>().value.user
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            QrBottomSheetContentBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.qr.load(profileViewModel.generateQRCode(user))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
