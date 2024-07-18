package com.example.gen_code_ai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Seats")
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "theaters_id")
    private TheatersEntity theater;

    @Column(name = "row_num")
    private String rowNumber;

    @Column(name = "seat_number")
    private Integer seatNumber;

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}
