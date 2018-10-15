package com.example.axel.studentportal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PortalAdapter(private val mPortals: MutableList<Portal>?, private val mPortalClickListener: MainActivity?) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(android.R.layout.simple_list_item_1, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        val portal = mPortals!![position]
        holder.textView.text = portal.getTitle()
    }

    override fun getItemCount(): Int {
        return mPortals!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textView: TextView

        init {
            textView = itemView.findViewById(android.R.id.text1)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val clickedPosition = adapterPosition
            mPortalClickListener!!.portalOnClick(clickedPosition)
        }
    }

    interface PortalClickListener {
        fun portalOnClick(i: Int)
    }
}
