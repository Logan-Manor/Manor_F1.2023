package com.example.manor_f12023.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.manor_f12023.databinding.ListItemTeamBinding

class TeamHolder(
    private val binding: ListItemTeamBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(team: Team, onTeamClicked: (TeamRank:Int) -> Unit) {
        binding.teamName = team.name

        // send to the TeamDetailFragment

        binding.root.setOnClickListener {
            onTeamClicked((team.rank)!!.toInt())
        }

    }

}
class TeamListAdapter(
    private val teams: List<Team>,
    private val onTeamClicked: (TeamRank: Int) -> Unit
) : RecyclerView.Adapter<TeamHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemTeamBinding.inflate(inflater, parent, false)
        return TeamHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        val team = teams[position]
        holder.bind(team, onTeamClicked)
    }

    override fun getItemCount() = teams.size
}