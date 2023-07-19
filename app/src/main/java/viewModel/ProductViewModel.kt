package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import giseys.Product
import kotlinx.coroutines.launch
import repository.ProductRepository

class ProductViewModel : ViewModel() {
    private val productRepo = ProductRepository()
    val productLiveData = MutableLiveData<List<Product>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchProducts() {
        viewModelScope.launch {
            val response = productRepo.getProducts()
            if (response.isSuccessful) {
                productLiveData.postValue(response.body()?.products)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
