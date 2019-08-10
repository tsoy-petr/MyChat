package com.hootor.mychat.ui.friends

import android.view.View
import com.hootor.mychat.R
import com.hootor.mychat.domain.friends.FriendEntity
import com.hootor.mychat.ui.core.BaseAdapter
import kotlinx.android.synthetic.main.item_friend.view.*


open class FriendsAdapter : BaseAdapter<FriendsAdapter.FriendViewHolder>() {
    override val layoutRes = R.layout.item_friend

    override fun createHolder(view: View, viewType: Int): FriendViewHolder {
        return FriendViewHolder(view)
    }

    class FriendViewHolder(view: View) : com.hootor.mychat.ui.core.BaseAdapter.BaseViewHolder(view) {

        init {
            view.btnRemove.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? FriendEntity)?.let {
                view.tvName.text = it.name
                view.tvStatus.text = it.status
            }

        }
    }
}