package ru.ifmo.mterentev.repository

import ru.ifmo.mterentev.model.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : ReactiveMongoRepository<Product, Long>