package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class VisitServiceTest {
 @Autowired ClinicTableService service;
 @Test void create() { assertEquals("rabies shot",service.findById("visits",1).get("DESCRIPTION")); assertEquals(1,service.create("visits", "id, description, pet_id, visit_date", "?, ?, ?, ?", 101, "checkup", 1, java.sql.Date.valueOf("2026-11-06"))); assertEquals("checkup",service.findById("visits",101).get("DESCRIPTION")); }
 @Test void findById() { assertEquals("rabies shot",service.findById("visits",1).get("DESCRIPTION")); }
 @Test void update() { service.create("visits", "id, description, pet_id, visit_date", "?, ?, ?, ?", 101, "checkup", 1, java.sql.Date.valueOf("2026-11-06")); assertEquals(1,service.update("visits","description = ?","updated",101)); assertEquals("updated",service.findById("visits",101).get("DESCRIPTION")); }
 @Test void delete() { service.create("visits", "id, description, pet_id, visit_date", "?, ?, ?, ?", 101, "checkup", 1, java.sql.Date.valueOf("2026-11-06")); assertEquals(1,service.delete("visits",101)); assertEquals(0,service.count("visits",101)); }
}
