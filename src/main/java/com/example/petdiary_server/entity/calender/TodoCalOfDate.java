package com.example.petdiary_server.entity.calender;

import com.example.petdiary_server.dto.calender.res.TodosCalOfDateRes;
import com.example.petdiary_server.dto.calender.res.TodoCalRes;
import com.example.petdiary_server.dto.calender.res.AllTodosInfoRes;
import com.example.petdiary_server.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TodoCalOfDate")
public class TodoCalOfDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoCalId;
    @Column(nullable = false, length = 12)
    private String date;
    @Column(nullable = false, length = 1)
    private int feelIdx;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public TodosCalOfDateRes createTodoCalDate() {
        return new TodosCalOfDateRes(date, feelIdx, user.getUserId());
    }

    public AllTodosInfoRes createAllTodosInfo(List<TodoCalRes> todoCalRes) {
        return new AllTodosInfoRes(date, feelIdx, user.getUserId(), todoCalRes);
    }
}
