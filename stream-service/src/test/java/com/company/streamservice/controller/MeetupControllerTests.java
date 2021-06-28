package com.company.streamservice.controller;

import com.company.streamservice.model.Meetup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MeetupController.class)
public class MeetupControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Meetup repo;

    private ObjectMapper mapper = new ObjectMapper();

    public Meetup repoMeetup;
    private String repoJson;
    private List<Meetup> allMeetups = new ArrayList<>();
    private String allMeetupsJson;

    @org.junit.Before
    public void setUp() throws Exception {
        repoMeetup = new Meetup();
        repoMeetup.setMeetupId(2);
        repoMeetup.setTitle("Department Happy Hour");
        repoMeetup.setDate("6/30/21");
        repoMeetup.setTime("5:00PM");
        repoMeetup.setDescription("First Friday of the month");
        repoMeetup.setLink("www.zoom.com/abcd56789");
        repoMeetup.setCategory("Happy Hour");
    }

    @Test
    public void shouldCreateNewMeetupEvent() throws Exception {
        Meetup createMeetup = new Meetup();
        createMeetup.setMeetupId(1);
        createMeetup.setUserId(1234);
        createMeetup.setTitle("Team Discussion");
        createMeetup.setDate("6/30/21");
        createMeetup.setTime("2:00 PM");
        createMeetup.setDescription("Discuss ways to improve team communication.");
        createMeetup.setLink("www.zoom.com/abcd56789");
        createMeetup.setCategory("Team Building");

        String inputJson = mapper.writeValueAsString(createMeetup);

        mockMvc.perform(
                post("/meetup")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(inputJson)
        );
    }

//    @Test
//    public void shouldGetAllMeetups() throws Exception {
//        given(repo.getAllMeetups()).willReturn(allMeetups);
//
//        mockMvc.perform(
//                get("/meetup"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(allMeetupsJson)
//        );
//    }

//    @Test
//    public void shouldGetMeetupById() throws Exception {
//        given(repo.getMeetupId()).willReturn(repoMeetup);
//
//        mockMvc.perform(
//                get("/meetup/9999"))
//                .andExpect(status().isOk())
//                .andExpect((content().json(repoJson))
//        );
//    }
}