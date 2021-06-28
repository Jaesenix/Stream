package com.company.streamservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.streamservice.model.Meetup;

import java.util.List;

public interface MeetupRepository extends JpaRepository<Meetup, Integer> {

    List<Meetup> findAllMeetupsByCategory(String category);

<<<<<<< HEAD
=======

>>>>>>> e98b7fc10ac96d055292f43dfbdb1d7e67cac3f4
}
