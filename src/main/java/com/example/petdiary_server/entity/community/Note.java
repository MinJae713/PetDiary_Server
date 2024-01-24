package com.example.petdiary_server.entity.community;

import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Note")
public class Note {
    @Id
    @Column(name = "noteId", nullable = false, length = 36)
    private String id;
    @Column(nullable = false)
    private String title;
    @Column(name = "noteDesc", nullable = false)
    private String desc;
    @Column(nullable = false)
    private boolean updated;
    @Column(nullable = false)
    private long time;
    @ManyToOne
    @JoinColumn(name = "screenKey")
    private Screen screen;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public NoteRes getNoteRes() {
        return new NoteRes(id, title, desc, time, screen.getTitle(), updated, user.getUserId(), user.getNickname());
    }
}
