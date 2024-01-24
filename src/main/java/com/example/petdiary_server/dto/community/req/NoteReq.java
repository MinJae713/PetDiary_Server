package com.example.petdiary_server.dto.community.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoteReq {
    protected String id;
    protected String title;
    protected boolean updated;
    protected String desc;
    protected long time;
    protected String userId;
    protected String screenTitle;
}
