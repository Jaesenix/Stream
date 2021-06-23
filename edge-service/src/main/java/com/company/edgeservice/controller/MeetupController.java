package com.company.edgeservice.controller;

import com.company.edgeservice.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetup")
public class MeetupController {
    @Autowired
    MeetupRepository meetupRepo;
}
