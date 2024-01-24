package com.example.petdiary_server.service.withDesignPattern.community.wrapper;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.community.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class NoteWrapper extends AbstWrapper{
    protected Note note;

    public NoteWrapper(boolean success, String message, User user, Note note) {
        super(success, message, user);
        this.note = note;
    }
}
