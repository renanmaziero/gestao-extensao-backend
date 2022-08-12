package com.ftunicamp.tcc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_profiles")
public class UserProfiles {
    @Id
    private Long user_id;

    private int profile_id;
}
