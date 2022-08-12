package com.ftunicamp.tcc.controllers;

import com.ftunicamp.tcc.dto.UserProfilesDto;
import com.ftunicamp.tcc.service.UserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profiles")
public class UserProfilesController {
    @Autowired
    private UserProfilesService userProfilesService;

    @GetMapping(value = "/{id}")
    public UserProfilesDto findById(@PathVariable Long id){
        return  userProfilesService.findById(id);

    }
}
