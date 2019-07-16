package com.kurczyna

import java.time.LocalDate

import spock.lang.Specification

class BookingSpec extends Specification {

    Listener listener = Mock()
    // or
    // def listener = Mock(Listener)
    Booking booking = new Booking(listener)

    def "should notify listener on booking confirmation"() {
        when:
        booking.confirm('booking-123')

        then:
        1 * listener.onBookingConfirmation({ BookingData data ->
            data.id == 'booking-123'
            data.paid // shorthand for data.paid == true
            data.created == LocalDate.now()
        })
    }
}

