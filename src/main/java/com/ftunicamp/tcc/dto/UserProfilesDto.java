package com.ftunicamp.tcc.dto;

import com.ftunicamp.tcc.model.UserProfiles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserProfilesDto {
    private int profile_id;

    public UserProfilesDto(UserProfiles userProfiles){
        profile_id = userProfiles.getProfile_id();
    }
}
