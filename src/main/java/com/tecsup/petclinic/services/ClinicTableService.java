package com.tecsup.petclinic.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClinicTableService {
    private final JdbcTemplate jdbc;

    public ClinicTableService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public int create(String table, String columns, String placeholders, Object... values) {
        return jdbc.update("INSERT INTO " + allowed(table) + " (" + columns + ") VALUES (" + placeholders + ")", values);
    }

    public Map<String, Object> findById(String table, int id) {
        return jdbc.queryForMap("SELECT * FROM " + allowed(table) + " WHERE id = ?", id);
    }

    public int update(String table, String assignment, Object value, int id) {
        return jdbc.update("UPDATE " + allowed(table) + " SET " + assignment + " WHERE id = ?", value, id);
    }

    public int delete(String table, int id) {
        return jdbc.update("DELETE FROM " + allowed(table) + " WHERE id = ?", id);
    }

    public int count(String table, int id) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM " + allowed(table) + " WHERE id = ?", Integer.class, id);
    }

    public List<Map<String, Object>> findSpecialtiesByVet(int vetId) {
        return jdbc.queryForList("SELECT * FROM vet_specialties WHERE vet_id = ?", vetId);
    }

    public int assignSpecialty(int vetId, int specialtyId) {
        return jdbc.update("INSERT INTO vet_specialties (vet_id, specialty_id) VALUES (?, ?)", vetId, specialtyId);
    }

    public int removeSpecialty(int vetId, int specialtyId) {
        return jdbc.update("DELETE FROM vet_specialties WHERE vet_id = ? AND specialty_id = ?", vetId, specialtyId);
    }

    private String allowed(String table) {
        return switch (table) {
            case "vets", "owners", "specialties", "visits", "types" -> table;
            default -> throw new IllegalArgumentException("Unsupported table: " + table);
        };
    }
}
