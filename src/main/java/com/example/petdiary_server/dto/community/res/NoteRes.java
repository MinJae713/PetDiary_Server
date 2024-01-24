package com.example.petdiary_server.dto.community.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoteRes {
    private String id;
    private String title;
    private String desc;
    private long time;
    private String screenTitle;
    private boolean updated;
    private String userId;
    private String nickname;
}
