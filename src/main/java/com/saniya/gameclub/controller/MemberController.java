package com.saniya.gameclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saniya.gameclub.exceptions.IdNotPresentException;
import com.saniya.gameclub.modal.Member;
import com.saniya.gameclub.services.MemberService;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping
    public ResponseEntity<Member> create(@RequestBody Member member) {
        Member savedMember = service.create(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        List<Member> members = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Member> findById(@PathVariable String id) throws IdNotPresentException {
        Member member = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Member> update(@PathVariable String id, @RequestBody Member member) throws IdNotPresentException {
        Member updatedMember = service.update(id, member);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMember);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws IdNotPresentException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}