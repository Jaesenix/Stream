package com.company.streamservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String title;
    private String description;
    private String link;
    private String category;

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
@JoinColumn(name = "userId")
    private Set<Meetup> meetups= new HashSet<>();

public User(){

}

    public User(Integer userId, String title, String description, String link, String category, Set<Meetup> meetups) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.link = link;
        this.category = category;
        this.meetups = meetups;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<Meetup> getMeetups() {
        return meetups;
    }

    public void setMeetups(Set<Meetup> meetups) {
        this.meetups = meetups;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(title, user.title) && Objects.equals(description, user.description) && Objects.equals(link, user.link) && Objects.equals(category, user.category) && Objects.equals(meetups, user.meetups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, description, link, category, meetups);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                ", meetups=" + meetups +
                '}';
    }
}
