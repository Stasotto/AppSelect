package com.example.appselect.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.appselect.data.models.MovieResponse
import com.example.appselect.domain.models.MovieDomain

typealias MoviePageLoader = suspend (offset: Int) -> MovieResponse

class MoviesPagingSource(
    private val loader: MoviePageLoader,
) : PagingSource<Int, MovieDomain>() {

    override fun getRefreshKey(state: PagingState<Int, MovieDomain>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(20) ?: page.nextKey?.minus(20)
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDomain> {
        val offset = params.key ?: 0
        return try {
            val response = loader.invoke(offset)
            return LoadResult.Page(
                data = response.toListMovieEntity().map { movieEntity ->
                    movieEntity.toMovieDomain()
                },
                prevKey = if (offset == 0) null else offset - response.num_results,
                nextKey = if (response.has_more) offset + response.num_results else null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}