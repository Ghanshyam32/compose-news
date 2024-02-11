package com.ghanshyam.composenews.ui.repositories

import com.ghanshyam.composenews.dataLayer.datasource.NewsDataSource
import com.ghanshyam.composenews.dataLayer.entity.NewsResponse
import com.ghanshyam.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import retrofit2.Response
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
//    suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
//        return newsDataSource.getNewsHeadLine(country)
//    }

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadLine(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error occurred!"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e?.localizedMessage ?: "Some error in flow"))
        }
    }

}