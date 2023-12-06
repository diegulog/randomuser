package com.diegulog.randomuser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.diegulog.randomuser.databinding.ItemUserBinding
import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.ui.base.BaseAdapter
import com.diegulog.randomuser.utils.load

class UserAdapter(onItemClick: (Int, User) -> Unit ) : BaseAdapter<User, ItemUserBinding>(onItemClick) {

    override fun onBind(binding: ItemUserBinding, item: User?, position: Int) {
        item?.let {
            binding.name.text = "${it.name.first} ${it.name.last}"
            binding.image.load(it.picture.large)
            binding.email.text = it.email
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater, parent: ViewGroup): ItemUserBinding {
        return ItemUserBinding.inflate(inflater, parent, false)
    }
}