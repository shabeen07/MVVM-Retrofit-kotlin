package com.devcods.mvvm_retrofit_kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devcods.mvvm_retrofit_kotlin.R
import com.devcods.mvvm_retrofit_kotlin.models.User

class UserAdapter (private var users: List<User>, private val context: Context) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvName : TextView = itemView.findViewById(R.id.tv_name)
            val tvDetails : TextView = itemView.findViewById(R.id.tv_user_details)
            val tvAddress : TextView = itemView.findViewById(R.id.tv_Address)
            val tvGeo : TextView = itemView.findViewById(R.id.tv_geo)
            val tvCompany : TextView = itemView.findViewById(R.id.tv_company)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
       return UserHolder(LayoutInflater.from(context).
                    inflate(R.layout.user_item_row,parent,false))
    }

    fun addAll(userList: List<User>){
        this.users = userList
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user  = users[position]
        holder.tvName.text = user.name
        val userDetails = user.username + "\n" + user.email + "\n" +
                user.phone +"\n" + user.website
        holder.tvDetails.text = userDetails
        val address  = user.address?.street + " , "+ user.address?.suite +
                "\n"+ user.address?.city+ " , "+ user.address?.zipcode
        holder.tvAddress.text = address
        val geo = user.address?.geo?.lat.toString() +" , " + user.address?.geo?.lng.toString()
        holder.tvGeo.text = geo
        val company = user.company?.name + "\n" + user.company?.catchPhrase + " , " + user.company?.bs
        holder.tvCompany.text = company

    }

    override fun getItemCount(): Int {
        return users.size
    }
}