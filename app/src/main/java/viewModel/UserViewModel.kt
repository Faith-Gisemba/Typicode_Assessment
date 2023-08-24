package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apis.User
import kotlinx.coroutines.launch
import repository.UserRepository

class UserViewModel : ViewModel() {
    private val userRepo = UserRepository()
    val userLiveData = MutableLiveData<List<User>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchUsers() {
        viewModelScope.launch {
            val response = userRepo.getUsers()
            if (response.isSuccessful) {
                userLiveData.postValue(response.body()?.users)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}


