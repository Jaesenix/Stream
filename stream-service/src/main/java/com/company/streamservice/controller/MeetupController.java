package com.company.streamservice.controller;

import com.company.streamservice.model.Meetup;
import com.company.streamservice.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetup")
public class MeetupController {
    @Autowired
    MeetupRepository meetupRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meetup createMeetup(@RequestBody Meetup meetup) {
        return meetupRepo.save(meetup);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Meetup> getAllMeetups(){
        return meetupRepo.findAll();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Meetup getMeetupById(@PathVariable Integer id) {
        return meetupRepo.getById(id);
    }
}