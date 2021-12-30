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
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home_second, container, false)
        binding = FragmentHomeThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(homeViewModel) {
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
                            .load("https://image.tmdb.org/t/p/w500" + itmovie.backdrop_path)
                            .into(binding.fontFilm)
                    }
                    (activity as? Titlechange)?.updateTitle(getString(R.string.home_third, binding.titre.text))
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
