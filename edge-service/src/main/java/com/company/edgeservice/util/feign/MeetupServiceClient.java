package com.company.edgeservice.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "stream-service")
public class MeetupServiceClient {
    @GetMapping("/meetups")
    public List<Meetup>
}
