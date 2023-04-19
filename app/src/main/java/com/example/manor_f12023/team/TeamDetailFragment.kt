package com.example.manor_f12023.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.manor_f12023.databinding.FragmentTeamDetailBinding
import kotlinx.coroutines.launch

class TeamDetailFragment : Fragment() {
    private var _binding: FragmentTeamDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val args: ZodiacDetailFragmentArgs by navArgs()


    private val teamDetailViewModel: TeamDetailViewModel by viewModels {
        TeamDetailViewModelFactory(args.TeamRank)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                teamDetailViewModel.team.collect { team ->
                    team?.let { updateUi(it) }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUi(team: Team) {
        binding.apply {
            if (teamName.text.toString() != team.name) {
                teamName.setText(team.name)
            }
            teamChief.text = team.chief
            teamDriver1.text = team.driver1
            teamDriver2.text = team.driver2
            teamChampionships.text = team.championships

        }
    }
}