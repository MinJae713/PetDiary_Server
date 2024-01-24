package com.example.petdiary_server.controller;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.dto.community.res.ScreenRes;
import com.example.petdiary_server.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;
    @GetMapping("/getNotes")
    public ResponseEntity<ResStatus<List<NoteRes>>> getNotes(
            @RequestParam String userId,
            @RequestParam String screenTitle) {
        ResStatus<List<NoteRes>> result = communityService.getNotes(userId, screenTitle);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/submitNote")
    public ResponseEntity<ResStatus<List<NoteRes>>> submitNote(
            @RequestBody NoteReq noteReq) {
        ResStatus<List<NoteRes>> result = communityService.submitNote(noteReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PatchMapping("/editNote")
    public ResponseEntity<ResStatus<List<NoteRes>>> editNote(
            @RequestBody NoteReq noteReq) {
        ResStatus<List<NoteRes>> result = communityService.editNote(noteReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/deleteNote")
    public ResponseEntity<ResStatus<List<NoteRes>>> deleteNote(
            @RequestParam String id,
            @RequestParam String userId) {
        ResStatus<List<NoteRes>> result = communityService.deleteNote(id, userId);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/screenTitles")
    public ResponseEntity<ResStatus<List<ScreenRes>>> getScreenTitles(
            @RequestParam String type) {
        ResStatus<List<ScreenRes>> result = communityService.getScreenTitles(type);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
