package ui

    import android.os.Bundle
    import android.widget.Toast
    import androidx.activity.viewModels
    import androidx.appcompat.app.AppCompatActivity
    import androidx.lifecycle.Observer
    import androidx.recyclerview.widget.LinearLayoutManager
    import apis.UsersAdapter
    import com.gisey.typicode.databinding.ActivityMainBinding
    import viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        private val userViewModel: UserViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        override fun onResume() {
            super.onResume()
            userViewModel.fetchUsers()
            userViewModel.userLiveData.observe(this, Observer { userList ->
                val userAdapter = UsersAdapter(userList?: emptyList())
                binding.rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvUsers.adapter = userAdapter
                Toast.makeText(baseContext, "Fetched ${userList?.size} users", Toast.LENGTH_LONG).show()
            })

            userViewModel.errorLiveData.observe(this, Observer { error ->
                Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            })
        }
    }






































//    fun getProducts(){
//        val apiclient= ApiClient.buildClient(ApiInterface::class.java)
//        val request=apiclient.getProducts()
//        request.enqueue(object : Callback<ProductResponse> {
//            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
//                if(response.isSuccessful){
//                    val products=response.body()?.products
//                    val productAdapter = ProductsAdapter(products ?: emptyList())
//                    binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
//                    binding.rvProducts.adapter = productAdapter
//                    Toast.makeText(baseContext,"fetched ${products?.size} products",Toast.LENGTH_LONG).show()
////                    finish()
//                }
//                else{
//                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
//                }
//
//
//            }
//
//            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
////                finish()
//
//            }
//        })
//    }

//}