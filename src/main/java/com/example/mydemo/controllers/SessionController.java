package com.example.mydemo.controllers;

import com.example.mydemo.models.Session;
import com.example.mydemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {
    public SessionController(){

    }

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        System.out.println("hiiiiiii----->>>>>get all sessions:- ");
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }


}
