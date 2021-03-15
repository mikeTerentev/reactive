package ru.ifmo.mterentev.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.beans.ConstructorProperties

@Suppress("unused")
@Document
class User @ConstructorProperties("id", "name", "currency") constructor(
    @Id val id: Long,
    val name: String,
    val currency: Currency
)
