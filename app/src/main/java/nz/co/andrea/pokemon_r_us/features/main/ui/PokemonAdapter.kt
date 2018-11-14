package nz.co.andrea.pokemon_r_us.features.main.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.pokemon_list_item.view.*
import nz.co.andrea.pokemon_r_us.R
import nz.co.andrea.pokemon_r_us.features.common.domain.Pokemon

class PokemonAdapter(
        private val pokemons: List<Pokemon>,
        private val listItemClickListener: ListItemClickListener
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    interface ListItemClickListener {
        fun onListItemClicked(pokemon: Pokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = pokemons.size

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        private val name = itemView.pokemonName

        fun bind(item: Int) {
            name.text = pokemons[item].name
        }

        override fun onClick(v: View) {
            listItemClickListener.onListItemClicked(pokemons[adapterPosition])
        }
    }
}