package com.ftunicamp.tcc.repositories;

import com.ftunicamp.tcc.model.UserProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfilesRepository extends JpaRepository<UserProfiles, Long> {
}
