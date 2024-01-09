package com.Train.TrainMicroservice.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Long id;
    @Column(name = "train_number", nullable = false)
    private int trainNumber;
    @Column(name = "train_name", nullable = false)
    private String trainName;

    @Column(name = "total_kms", nullable = false)
    private double totalKms;

    @Column(name = "ac_coaches", nullable = false)
    private int acCoaches;

    @Column(name = "ac_coach_total_seats", nullable = false)
    private int acCoachTotalSeats;

    @Column(name = "sleeper_coaches", nullable = false)
    private int sleeperCoaches;

    @Column(name = "sleeper_coach_total_seats", nullable = false)
    private int sleeperCoachTotalSeats;

    @Column(name = "general_coaches", nullable = false)
    private int generalCoaches;

    @Column(name = "general_coach_total_seats", nullable = false)
    private int generalCoachTotalSeats;
}
