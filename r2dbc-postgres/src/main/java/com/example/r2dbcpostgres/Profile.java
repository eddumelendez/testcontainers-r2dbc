package com.example.r2dbcpostgres;

import org.springframework.data.relational.core.mapping.Table;

@Table
public record Profile(String id, String name) {
}
