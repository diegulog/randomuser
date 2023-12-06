package com.diegulog.randomuser.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.diegulog.randomuser.R
import com.diegulog.randomuser.databinding.FragmentHomeBinding
import com.diegulog.randomuser.ui.adapter.UserAdapter
import com.diegulog.randomuser.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(), MenuProvider {

    private val userViewModel: UserViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(this)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val userAdapter = UserAdapter { _, user ->
            val direction = HomeFragmentDirections.actionHomeFragmentToProfileFragment(user)
            Navigation.findNavController(view).navigate(direction)
        }

        binding.recyclerView.adapter = userAdapter
        userViewModel.uiState.observe(viewLifecycleOwner) { state ->
            with(state) {
                binding.errorContainer.isVisible = error != null && users.isEmpty()
                binding.progress.isVisible = isLoading
                userAdapter.setItems(users)

                error?.let {
                    if(users.isEmpty()){
                        binding.error.text = it.message
                    }else{
                        showMessage("Unable to update contact list. Please check your connection")
                    }
                }
                binding.retry.setOnClickListener {
                    userViewModel.getFirstPage()
                }
            }
        }

    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_main, menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.action_refresh -> {
                userViewModel.getFirstPage()
            }

        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().removeMenuProvider(this)
    }


}
