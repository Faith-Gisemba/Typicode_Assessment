package giseys

import giseys.Product

data class ProductResponse(
    var products:List<Product>,
    val total :Int,
    val skip:Int,
    var limit:Int
)
