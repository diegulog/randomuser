package com.diegulog.randomuser.di

import com.diegulog.randomuser.ui.home.UserViewModel
import com.diegulog.randomuser.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserViewModel(get()) }
    viewModel { ProfileViewModel(get()) }

}

