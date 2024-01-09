package com.Train.TrainMicroservice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_Id")
    private int postId;
    @Column(name = "post_Title")
    private String postTitle;
    @Column(name = "post_Category")
    private String postCategory;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    @JsonBackReference
    private User user;
}
