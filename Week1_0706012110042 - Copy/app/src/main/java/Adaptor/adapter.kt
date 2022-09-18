package Adaptor

import Interface.cardLIstener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1_0706012110042.R
import com.example.week1_0706012110042.databinding.CardviewhewanBinding
import model.hewan

class adapter(val listhewan: ArrayList<hewan>, val cardLIstener: cardLIstener):
    RecyclerView.Adapter<adapter.viewHolder>(){

    class viewHolder(val itemView: View, val cardLIstener: cardLIstener):
        RecyclerView.ViewHolder(itemView) {

        val binding = CardviewhewanBinding.bind(itemView)

            fun setData(data: hewan) {
                binding.textView4.text = data.nama
                binding.textView5.text = data.jenis
                binding.textView6.text = "Usia: " + data.usia + " Tahun"

                itemView.setOnClickListener{
                    cardLIstener.onCardClick(adapterPosition)
                }

                binding.button2.setOnClickListener{
                    cardLIstener.onEditClick(adapterPosition)
                }

                binding.button3.setOnClickListener{
                    cardLIstener.onDeleteClick(adapterPosition)
                }

            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cardviewhewan, parent,false)
        return viewHolder(view, cardLIstener)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setData(listhewan[position])

    }

    override fun getItemCount(): Int {
        return listhewan.size
    }
}