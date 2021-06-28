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

import static org.junit.Assert.;

@RunWith(SpringRunner.class)
@WebMvcTest(MeetupController.class)
public class MeetupControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Meetup repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Meetup repoMeetup;
    private String repoJson;
    private List<Meetup> allMeetups = new ArrayList<>();
    private String allMeetupsJson;

    @org.junit.Before
    public void setUp() throws Exception {
        repoMeetup = new Meetup();
        repoMeetup.setMeetupId();
        repoMeetup.setTitle();
        repoMeetup.setDate();
        repoMeetup.setTime();
        repoMeetup.setDescription();
        repoMeetup.setLink();
        repoMeetup.setCategory();
    }

    @Test
    public shouldCreateNewMeetupEvent() throws Exception {
        Meetup createMeetup = new Meetup();
        createMeetup.setMeetupId();
        createMeetup.setUserId();
        createMeetup.setTitle();
        createMeetup.setDate();
        createMeetup.setTime();
        createMeetup.setDescription();
        createMeetup.setLink();
        createMeetup.setCategory();

        String inputJson = mapper.writeValueAsString(createMeetup);

        mockMvc.perform(
                post("/meetup")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(inputJson))
        );
    }

    @Test
    public void shouldGetAllMeetups() throws Exception {
        given(repo.getAllMeetups()).willReturn(allMeetups);

        mockMvc.perform(
                get("/meetup"))
                .andExpect(status().isOk())
                .andExpect(content().json(allMeetupsJson)
        );
    }

    @Test
    public void shouldGetMeetupById() throws Exception {
        given(repo.getMeetup()).willReturn(Meetup);

        mockMvc.perform(
                get("/meetup"))
                .andExpect((status().isOk())
                .andExpect((content().json(repoJson))
        );
    }
}