package com.example.r2dbcpostgres;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProfileRepository extends R2dbcRepository<Profile, String> {
}
