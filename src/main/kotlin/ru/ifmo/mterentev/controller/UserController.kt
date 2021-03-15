package ru.ifmo.mterentev.controller

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.ifmo.mterentev.model.Product
import ru.ifmo.mterentev.model.User
import ru.ifmo.mterentev.exceptions.UserNotFoundException
import ru.ifmo.mterentev.service.UserService


@RestController
class UserController(private val userService: UserService) {
    @PostMapping(value = ["user"])
    fun addUser(@RequestBody user: User): Mono<User> {
        return userService.addUser(user)
    }

    @GetMapping(value = ["user/{id}"])
    fun getUser(@PathVariable id: Long): Mono<User> {
        return userService.findUserById(id).switchIfEmpty(Mono.error(UserNotFoundException("User not found: $id")));
    }

    @DeleteMapping(value = ["user/remove/{id}"])
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUserById(id)
    }

    @GetMapping(value = ["user/{id}/products"])
    fun getProducts(@PathVariable id: Long): Flux<Product> {
        return userService.getUserProducts(id)
    }
}