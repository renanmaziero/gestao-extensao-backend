package com.ftunicamp.tcc.service;

import com.ftunicamp.tcc.dto.UserProfilesDto;
import com.ftunicamp.tcc.model.UserProfiles;
import com.ftunicamp.tcc.repositories.UserProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfilesService {
    @Autowired
    private UserProfilesRepository userProfilesRepository;
    public UserProfilesDto findById(Long id){
        UserProfiles userProfiles = userProfilesRepository.findById(id).get();
        UserProfilesDto userProfilesDto = new UserProfilesDto(userProfiles);
        return userProfilesDto;
    }

    public void UpdateUserProfiles(Long id, int profile){
        UserProfiles userProfiles = userProfilesRepository.findById(id).get();
        userProfiles.setProfile_id(profile);
        userProfilesRepository.save(userProfiles);

    }
}
