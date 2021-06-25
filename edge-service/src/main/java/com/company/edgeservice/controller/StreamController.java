package com.company.edgeservice.controller;

import com.company.edgeservice.model.Meetup;
import com.company.edgeservice.model.User;
import com.company.edgeservice.util.feign.MeetupServiceClient;
import com.company.edgeservice.util.feign.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stream")
public class StreamController {
    @Autowired
    private MeetupServiceClient meetupFeignClient;
    @Autowired
    private UserServiceClient userFeignClient;

    @RequestMapping(value="/meetup", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Meetup> getAllMeetups(){
        System.out.println("called the edge service. getting all meetups");
        return meetupFeignClient.getAllOfTheMeetups();

    }

    @RequestMapping(value="/meetup", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Meetup addMeetup(@RequestBody Meetup meetup) {
        System.out.println("called edge service. Meetup made");
        return meetupFeignClient.creatingANewMeetup(meetup);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Meetup> getAllUsers(){
        System.out.println("called the edge service. getting all users");
        return userFeignClient.getAllOfTheUsers();

    }

    @RequestMapping(value="/user", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User addUser(@RequestBody User user) {
        System.out.println("called edge service. User made");
        return userFeignClient.creatingANewUser(user);
    }
}
