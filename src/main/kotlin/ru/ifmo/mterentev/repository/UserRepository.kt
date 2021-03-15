package ru.ifmo.mterentev.repository

import ru.ifmo.mterentev.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository<User, Long>