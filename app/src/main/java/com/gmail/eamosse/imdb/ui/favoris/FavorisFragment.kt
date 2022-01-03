package com.gmail.eamosse.imdb.ui.favoris

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.gmail.eamosse.idbdata.data.Movie
import com.gmail.eamosse.idbdata.local.entities.FavoriteEntity
import com.gmail.eamosse.imdb.databinding.FragmentFavorisBinding
import com.gmail.eamosse.imdb.ui.home.HomeThirdFragmentArgs
import com.gmail.eamosse.imdb.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavorisFragment : Fragment() {
    private val favorisViewModel: FavorisViewModel by viewModel()
    private val args: HomeThirdFragmentArgs by navArgs()
    private lateinit var binding: FragmentFavorisBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavorisBinding.inflate(inflater, container, false)
        val adapter = FavorisAdapter()
        with(favorisViewModel) {
            getFavorites()
            favorites.observe(
                viewLifecycleOwner,
                Observer {
                    adapter.setMovieList(it)
                    binding.apply {
                        rvMovie.setHasFixedSize(true)
                        rvMovie.adapter = adapter
                    }
                }
            )
        }
        adapter.setOnItemClickCallback(object : FavorisAdapter.OnItemClickCallback {
            override fun onItemClick(favoriteMovie: FavoriteEntity) {
                val movie = Movie(
                    favoriteMovie.id_movie.toInt(),
                    favoriteMovie.poster_path,
                    favoriteMovie.backdroppath,
                    favoriteMovie.video,
                    favoriteMovie.original_title,
                    favoriteMovie.release_date,
                    favoriteMovie.overview
                )
//                val action = FavoriteFragmentDirections.actionNavFavoriteToNavDetails(movie)
//                findNavController().navigate(action)
            }
        })
        return binding.root
    }
}
