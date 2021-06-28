package com.company.streamservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="meetup")
public class Meetup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer meetupId;
    private String title;
    private String date;
    private String time;
    private String description;
    private String link;
    private String category;

    public Meetup() {

    }

    public Meetup(Integer meetupId, String title, String date, String time, String description, String link, String category) {
        this.meetupId = meetupId;
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
        this.link = link;
        this.category = category;
    }

    public Integer getMeetupId() {
        return meetupId;
    }

    public void setMeetupId(Integer meetupId) {
        this.meetupId = meetupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meetup meetup = (Meetup) o;
        return Objects.equals(meetupId, meetup.meetupId) && Objects.equals(title, meetup.title) && Objects.equals(date, meetup.date) && Objects.equals(time, meetup.time) && Objects.equals(description, meetup.description) && Objects.equals(link, meetup.link) && Objects.equals(category, meetup.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetupId, title, date, time, description, link, category);
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "meetupId=" + meetupId +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}