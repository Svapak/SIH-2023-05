package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.waterproject.R
import com.squareup.picasso.Picasso
import dataclass.issues
import dataclass.problems
import dataclass.solutions

class issuesAdapter (private val itemList: ArrayList<issues> = ArrayList<issues>()):
    RecyclerView.Adapter<issuesAdapter.MyViewHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.issue_review_itemlayout,
            parent,false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = itemList[position]

        if(currentitem.imageURL!=null){
            Picasso.get().load(currentitem.imageURL).into(holder.imageUrlIV)
        }
        holder.estimatedLossTV.text = currentitem.estimatedloss
//        holder.problemTV.text = currentitem.problem
//        holder.descriptionTV.text = currentitem.description
        holder.typeTV.text = currentitem.type
        holder.cityTV.text = currentitem.city
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updateItemList(itemList: List<issues>){
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageUrlIV: ImageView= itemView.findViewById(R.id.image)
        val estimatedLossTV : TextView = itemView.findViewById(R.id.probableLoss)
        val typeTV : TextView = itemView.findViewById(R.id.type)
        val cityTV: TextView = itemView.findViewById(R.id.city)
    }

}