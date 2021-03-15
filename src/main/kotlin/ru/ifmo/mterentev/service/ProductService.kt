package ru.ifmo.mterentev.service

import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import ru.ifmo.mterentev.model.Product
import ru.ifmo.mterentev.repository.ProductRepository
import ru.ifmo.mterentev.exceptions.ProductNotFoundException

@Component
class ProductService(private val productRepository: ProductRepository) {
    fun addProduct(product: Product): Mono<Product> {
        return productRepository.insert(product)
    }

    fun getProductById(id: Long): Mono<Product> {
        return productRepository.findById(id).switchIfEmpty(Mono.error(ProductNotFoundException("Product by not found $id")))
    }

    fun deleteProductById(id: Long) {
        productRepository.deleteById(id)
    }
}
