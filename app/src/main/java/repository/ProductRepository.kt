package repository

import giseys.ApiClient
import giseys.ApiInterface
import giseys.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts(): Response<ProductResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }

    }
}