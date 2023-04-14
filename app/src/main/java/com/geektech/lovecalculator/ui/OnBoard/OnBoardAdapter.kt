package com.geektech.lovecalculator.ui.OnBoard


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.ItemOnboardBinding

class OnBoardAdapter(private val onStartClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoardModel(
            "Have a good time",
            "You should take the time to help those who need you",
            R.drawable.result
        ),
        OnBoardModel(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.drawable.heart
        ),
        OnBoardModel(
            "Have a break up?",
            "We have made the correction for you don't worry. Maybe someone is waiting for you",
            R.drawable.heart
        ),
        OnBoardModel(
            "It's Funs and Many more", "",
            R.drawable.heart
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
          ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :

        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoardModel) {
            binding.apply {
                lottie.setImageResource(onBoard.image)
                tvTittle.text = onBoard.tittle
                tvDescription.text = onBoard.desc
            }
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }
}



