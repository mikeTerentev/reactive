package ru.ifmo.mterentev.currency

import ru.ifmo.mterentev.model.Currency
import ru.ifmo.mterentev.model.Product

object CurrencyConverter {
    private val currencyMultiplier = mapOf(
        Currency.RUB to 1.0,
        Currency.EUR to 87.57,
        Currency.USD to 73.26
    )

    fun convert(product: Product, currency: Currency): Product {
        val price = product.price / currencyMultiplier.getValue(currency) * currencyMultiplier.getValue(product.currency)
        return Product(product.id, product.name, currency, price)
    }
}
