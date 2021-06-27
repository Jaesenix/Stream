package com.company.streamservice.controller;

import com.company.streamservice.model.Meetup;
import com.company.streamservice.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MeetupController {
    @Autowired
    MeetupRepository meetupRepo;

    @PostMapping("/meetup")
    @ResponseStatus(HttpStatus.CREATED)
    public Meetup createMeetup(@RequestBody Meetup meetup) {
        return meetupRepo.save(meetup);
    }

    @GetMapping(value = "/meetup")
    @ResponseStatus(HttpStatus.OK)
    public List<Meetup> getAllMeetups(){
        return meetupRepo.findAll();
    }

    @GetMapping(value="/meetup/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Meetup getMeetupById(@PathVariable Integer id) {
        return meetupRepo.getById(id);
    }

    @GetMapping("/meetup/category/{category}")
    public List<Meetup> getMeetupByCategory(@PathVariable String category){
        return meetupRepo.findAllMeetupsByCategory(category);
    }

    @PutMapping("/meetup")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMeetup(@RequestBody Meetup meetup) {
        meetupRepo.save(meetup);
    }

}