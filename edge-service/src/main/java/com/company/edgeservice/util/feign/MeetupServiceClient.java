package com.company.edgeservice.util.feign;

import com.company.edgeservice.model.Meetup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "stream-service")
public interface MeetupServiceClient {

    @GetMapping("/meetup")
    public List<Meetup> getAllOfTheMeetups();

    @PostMapping("/meetup")
    public Meetup creatingANewMeetup(@RequestBody Meetup meetup);
}
