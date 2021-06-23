package com.company.streamservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.streamservice.model.Meetup;

public interface MeetupRepository extends JpaRepository<Meetup, Integer> {
}
