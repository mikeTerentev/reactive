package ru.ifmo.mterentev.configuration

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Suppress("SpringFacetCodeInspection")
@EnableReactiveMongoRepositories
class MongoReactiveApplication : AbstractReactiveMongoConfiguration() {
    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create("mongodb://localhost:11111")
    }

    override fun reactiveMongoClient(): MongoClient {
        return mongoClient()
    }

    override fun getDatabaseName(): String {
        return "shop"
    }
}

