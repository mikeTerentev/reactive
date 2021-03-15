package ru.ifmo.mterentev.controller

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import ru.ifmo.mterentev.model.Product
import ru.ifmo.mterentev.exceptions.ProductNotFoundException
import ru.ifmo.mterentev.service.ProductService


@RestController
class ProductController(private val productService: ProductService) {
    @PostMapping("product")
    fun addProduct(@RequestBody product: Product): Mono<Product> {
        return productService.addProduct(product)
    }

    @GetMapping("product/{id}")
    fun getProduct(@PathVariable id: Long): Mono<Product> {
        return productService.getProductById(id).switchIfEmpty(Mono.error(ProductNotFoundException("Product by id not found: $id")));
    }

    @DeleteMapping("product/{id}/del")
    fun deleteProduct(@PathVariable id: Long) {
        productService.deleteProductById(id)
    }
}
