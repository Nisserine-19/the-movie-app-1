package com.gmail.eamosse.imdb.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.FragmentDashboardSecondBinding
import com.gmail.eamosse.imdb.ui.home.Titlechange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardSecondFragment : Fragment() {
    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val args: DashboardSecondFragmentArgs by navArgs()
    private lateinit var binding: FragmentDashboardSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home_second, container, false)
        binding = FragmentDashboardSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(dashboardViewModel) {
            getSimilarMovies(args.idmovie.toInt())
            similarmovies.observe(
                viewLifecycleOwner,
                {
                    binding.similarList.adapter = DashboardAdapter(it)
                }
            )

            // récupérer les catégories
            getDetailMovie(args.idmovie.toInt())
            movieDetail.observe(
                viewLifecycleOwner,
                { itmovie ->
                    binding.titre.text = itmovie.title
                    binding.resume.text = itmovie.overview
                    binding.dateSortie.text = itmovie.date
                    binding.rang.rating = itmovie.vote_average.toFloat() / 2
                    context?.let { it1 ->
                        Glide.with(it1)
                            .load("https://image.tmdb.org/t/p/w500" + itmovie.poster_path)
                            .into(binding.imageFilm)
                    }
                    context?.let { it1 ->
                        Glide.with(it1)
                            .load("https://image.tmdb.org/t/p/w1280" + itmovie.backdrop_path)
                            .into(binding.fontFilm)
                    }
                    var _isChecked = false
                    CoroutineScope(Dispatchers.IO).launch {
                        val count = checkMovie(itmovie.id.toString())
                        withContext(Dispatchers.Main) {
                            if (count > 0) {
                                binding.toggleFavorite.isChecked = true
                                _isChecked = true
                            } else {
                                binding.toggleFavorite.isChecked = false
                                _isChecked = false
                            }
                        }
                    }
                    binding.toggleFavorite.setOnClickListener {
                        _isChecked = !_isChecked
                        if (_isChecked) {
                            addToFavorite(itmovie)
                        } else {
                            removeFromFavorite(itmovie.id.toString())
                        }
                        binding.toggleFavorite.isChecked = _isChecked
                    }
                    (activity as? Titlechange)?.updateTitle(
                        getString(
                            R.string.dashboard_second,
                            binding.titre.text
                        )
                    )
                    error.observe(
                        viewLifecycleOwner,
                        {
                            // afficher l'erreur
                        }
                    )
                }
            )
        }
    }
}
