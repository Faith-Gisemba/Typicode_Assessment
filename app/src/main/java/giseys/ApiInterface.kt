package giseys

//An API interface in Android Studio is a way to define the methods that will be used to communicate with an API. It is a contract between the Android app and the API,
//and it ensures that the app and the API can understand each other.
//The API interface is typically a Java interface that contains the methods that will be used to communicate with the API. The methods in the API interface are annotated
//with the HTTP method that will be used to make the request, such as @GET, @POST, or @PUT. The methods also specify the URL of the API endpoint that will be called.

//This methods are used to make HTTPS Methods that is be used to respond to the API
//@GET is used to make a GET request. A GET request is used to retrieve data from an API
//@POST is used to make a POST request. A POST request is used to create new data in an API
//@PUT is used to make a PUT request. A PUT request is used to update existing data in an API


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    suspend fun getProducts(): Response<ProductResponse>

    @GET("/product")
    suspend fun getProducts(@Path("id") productid: Int): Response<Product>

}