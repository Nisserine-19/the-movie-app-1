package com.gmail.eamosse.imdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.FragmentHomeThirdBinding
import com.gmail.eamosse.imdb.ui.dashboard.DashboardAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeThirdFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()
    private val args: HomeThirdFragmentArgs by navArgs()
    private lateinit var binding: FragmentHomeThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeThirdBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(homeViewModel) {
            getSimilarMovies(args.idmovie.toInt())
            similarmovies.observe(
                viewLifecycleOwner,
                {
                    binding.similarList.adapter = DashboardAdapter(it)
                }
            )

            getDetailMovie(args.idmovie.toInt())
            movieDetail.observe(
                viewLifecycleOwner,
                { itmovie ->
                    binding.titre.text = itmovie.title
                    binding.resume.text = itmovie.overview
                    binding.dateSortie.text = itmovie.date
                    binding.originalLanguage.text = itmovie.original_language
                    binding.rang.rating = itmovie.vote_average.toFloat() / 2
                    context?.let { it1 ->
                        Glide.with(it1)
                            .load("https://image.tmdb.org/t/p/w500" + itmovie.poster_path)
                            .into(binding.imageFilm)
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

                    context?.let { it1 ->
                        Glide.with(it1)
                            .load("https://image.tmdb.org/t/p/w1280" + itmovie.backdrop_path)
                            .into(binding.fontFilm)
                    }

                    var companiesTxt = ""
                    for (j in itmovie.production_companies) {
                        companiesTxt += j.name + "\n"
                    }
                    binding.companie.text = companiesTxt

                    (activity as? Titlechange)?.updateTitle(
                        getString(
                            R.string.home_third,
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

            getVideo(args.idmovie.toInt())
            video.observe(
                viewLifecycleOwner,
                {
                    binding.videoList.adapter = VideoAdapter(it)
                }
            )
        }
    }
}
