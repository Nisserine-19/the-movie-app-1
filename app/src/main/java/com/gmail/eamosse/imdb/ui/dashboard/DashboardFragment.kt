package com.gmail.eamosse.imdb.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.eamosse.imdb.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModel()
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(dashboardViewModel) {

            getPopularMovies()
            popularmovies.observe(
                viewLifecycleOwner,
                {
                    binding.popularList.adapter = DashboardAdapter(it)
//                    binding.topRatedList.adapter = DashboardAdapter(it)
                }
            )
            getTopRatedMovies()
            topratedmovies.observe(
                viewLifecycleOwner,
                {
                    binding.topRatedList.adapter = DashboardAdapter(it)
                }
            )
            getUpcomingMovies()
            upcomingmovies.observe(
                viewLifecycleOwner,
                {
                    binding.upcomingList.adapter = DashboardAdapter(it)
                }
            )

            error.observe(
                viewLifecycleOwner,
                {
                    // afficher l'erreur
                }
            )
        }
    }
}
