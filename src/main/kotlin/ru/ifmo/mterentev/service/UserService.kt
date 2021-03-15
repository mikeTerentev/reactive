package ru.ifmo.mterentev.service

import ru.ifmo.mterentev.model.Product
import ru.ifmo.mterentev.model.User
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.ifmo.mterentev.repository.*
import ru.ifmo.mterentev.currency.CurrencyConverter
import ru.ifmo.mterentev.exceptions.UserNotFoundException


@Component
class UserService(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository
) {
    fun addUser(user: User): Mono<User> {
        return userRepository.insert(user)
    }

    fun findUserById(id: Long): Mono<User> {
        return userRepository.findById(id).switchIfEmpty(Mono.error(UserNotFoundException("User not found: $id")));
    }

    fun deleteUserById(id: Long) {
        userRepository.deleteById(id)
    }

    fun getUserProducts(id: Long): Flux<Product> {
        return userRepository.findById(id).flatMapMany { user ->
            productRepository.findAll()
                .map { product -> CurrencyConverter.convert(product, user.currency) }
        }
    }
}
