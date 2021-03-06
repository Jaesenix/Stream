package com.company.edgeservice.util.feign;

import com.company.edgeservice.model.Meetup;
import com.company.edgeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "stream-service")

public interface ServiceClient {

    @GetMapping("/meetup/category")
    public List<Meetup> getAllOfTheMeetups();

    @PostMapping("/meetup")
    public Meetup creatingANewMeetup(@RequestBody Meetup meetup);

    @GetMapping("/meetup/category/{category}")
    public List<Meetup> getAllOfTheMeetupsByCategory(@PathVariable String category);

    @GetMapping("/user")
    public List<Meetup> getAllOfTheUsers();

    @PostMapping("/user")
    public User creatingANewUser(@RequestBody User user);


}
