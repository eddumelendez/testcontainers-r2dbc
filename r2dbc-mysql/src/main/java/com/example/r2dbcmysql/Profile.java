package com.example.r2dbcmysql;

import org.springframework.data.relational.core.mapping.Table;

@Table
public record Profile(String id, String name) {
}
