package com.company.edgeservice.model;

import java.util.Objects;

public class Meetup {
    private String title;
    private String date;
    private String time;
    private String description;
    private String link;
    private String category;

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
        return Objects.equals(title, meetup.title) && Objects.equals(date, meetup.date) && Objects.equals(time, meetup.time) && Objects.equals(description, meetup.description) && Objects.equals(link, meetup.link) && Objects.equals(category, meetup.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, time, description, link, category);
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
