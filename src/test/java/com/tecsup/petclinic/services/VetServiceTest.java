package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class VetServiceTest {
 @Autowired ClinicTableService service;
 @Test void create() {
  assertEquals("James", service.findById("vets", 1).get("FIRST_NAME"));
  assertEquals(1, service.create("vets", "id, first_name", "?, ?", 101, "Ana"));
  assertEquals("Ana", service.findById("vets",101).get("FIRST_NAME"));
 }
 @Test void findById() { assertEquals("James",service.findById("vets",1).get("FIRST_NAME")); }
 @Test void update() {
  service.create("vets", "id, first_name", "?, ?", 101, "Ana");
  assertEquals(1,service.update("vets","first_name = ?","updated",101));
  assertEquals("updated",service.findById("vets",101).get("FIRST_NAME"));
 }
 @Test void delete() {
  service.create("vets", "id, first_name", "?, ?", 101, "Ana");
  assertEquals(1,service.delete("vets",101));
  assertEquals(0,service.count("vets",101));
 }
}
