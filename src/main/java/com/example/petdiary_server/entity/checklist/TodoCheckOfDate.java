package com.example.petdiary_server.entity.checklist;

import com.example.petdiary_server.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TodoCheckOfDate")
public class TodoCheckOfDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoCheckId;
    @Column(nullable = false, length = 12)
    private String writeDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
