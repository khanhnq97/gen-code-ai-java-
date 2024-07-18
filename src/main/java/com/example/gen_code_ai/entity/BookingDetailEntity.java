package com.example.gen_code_ai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "BookingDetails")
public class BookingDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_detail_id")
    private Integer bookingDetailId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seat;


    public Integer getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(Integer bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public SeatEntity getSeat() {
        return seat;
    }

    public void setSeat(SeatEntity seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "BookingDetailEntity{" + "bookingDetailId=" + bookingDetailId + ", booking=" + booking + ", seat=" + seat + '}';
    }
}