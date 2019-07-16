package com.kurczyna

import java.time.LocalDate

open class Animal(
    open val height: Int,
    open val weight: Int,
    open val name: String
)

data class Monkey(
    override val height: Int,
    override val weight: Int,
    override val name: String
): Animal(height, weight, name)

class Zoo {

    companion object {
        val map: Map<String, Animal> = mapOf(
            "bono" to Monkey(154, 93, "bono")
        )
    }

    fun findAnimal(name: String) = map[name]
}

interface Listener {
    fun onBookingConfirmation(bookingData: BookingData)
}

data class BookingData(val id: String, val paid: Boolean,
                       val created: LocalDate
)

class Booking(private val listener: Listener) {
    fun confirm(id: String) {
        val data = BookingData(
            id = id,
            paid = true,
            created = LocalDate.now()
        )
        listener.onBookingConfirmation(data)
    }
}

