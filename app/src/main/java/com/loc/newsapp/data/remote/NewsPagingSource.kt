package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.model.Article

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
): PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> { //want create request and load result to this func.
        //get page
        val page = params.key ?: 1 //start from page 1
        return try {

            val newsResponse = newsApi.getNews(sources = sources, page = page ) //get response
            totalNewsCount += newsResponse.articles.size //add each response we get
            val articles = newsResponse.articles.distinctBy{ it.title} //remove duplicate
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1, //if we should stop paging or not
                prevKey = null
                )

        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? { //first time or refresh
        return state.anchorPosition?.let {anchorPosition -> //anchorPosition latest access page in the list
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }
    }
}