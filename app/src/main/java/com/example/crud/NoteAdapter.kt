package com.example.crud

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.databinding.AdapterMainBinding
import com.example.crud.room.Note

class NoteAdapter (private var notes: ArrayList<Note>, private val listener:
OnAdapterListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){
    inner class NoteViewHolder(val binding: AdapterMainBinding) :
        RecyclerView.ViewHolder(binding.root)
    interface OnAdapterListener {
        fun onRead(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }
    private lateinit var binding : AdapterMainBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = AdapterMainBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return NoteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        with(holder) {
            with(notes[position]) {
                binding.textTitle.text = title
                binding.textTitle.setOnClickListener {
                    listener.onRead(notes[position])
                }
                binding.iconEdit.setOnClickListener {
                    listener.onUpdate(notes[position])
                }
                binding.iconDelete.setOnClickListener {
                    listener.onDelete(notes[position])
                }
            }
        }
    }
    override fun getItemCount() = notes.size
    fun setData(newList: List<Note>) {
        notes.clear()
        notes.addAll(newList)
        notifyDataSetChanged()
    }
}
