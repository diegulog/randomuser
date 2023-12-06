package com.diegulog.randomuser.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, VB : ViewBinding>(
    private var listener: (Int, T) -> Unit,
    private var items: List<T> = emptyList()
) : RecyclerView.Adapter<BaseAdapter.Holder<VB>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder<VB> {
        val binding = inflateViewBinding(LayoutInflater.from(parent.context), parent)
        return Holder(binding)
    }

    @CallSuper
    override fun onBindViewHolder(holder: Holder<VB>, position: Int) {
        holder.itemView.setOnClickListener {
            listener.invoke(position, items[position])
        }
        onBind(holder.binding, items[position], position)
    }

    fun setItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItems(): List<T> {
        return items
    }

    override fun getItemCount(): Int {
        return items.size
    }

    abstract fun onBind(binding: VB, item: T?, position: Int)

    protected abstract fun inflateViewBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    interface OnClickListener<T> {
        fun onClick(position:Int, item: T)
    }

    class Holder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
}
