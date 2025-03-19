package com.example.demo.Repository.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users userId;  // Changed field name to userId

    @ManyToOne
    @JoinColumn(name = "trainNumber", referencedColumnName = "TrainNumber")
    private Trains trainNumber;  // Changed field name to trainNumber

    @Column
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    @Column
    private String bookingReference;

    public Booking(int bookingId, Users userId, Trains trainNumber, Date bookingDate, String bookingReference) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.trainNumber = trainNumber;
        this.bookingDate = bookingDate;
        this.bookingReference = bookingReference;
    }

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Trains getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Trains trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", trainNumber=" + trainNumber +
                ", bookingDate=" + bookingDate +
                ", bookingReference='" + bookingReference + '\'' +
                '}';
    }
}
