package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class OwnerServiceTest {
 @Autowired ClinicTableService service;
 @Test void create() {
  assertEquals("George", service.findById("owners", 1).get("FIRST_NAME"));
  assertEquals(1, service.create("owners", "id, first_name", "?, ?", 101, "Ana"));
  assertEquals("Ana", service.findById("owners",101).get("FIRST_NAME"));
 }
 @Test void findById() { assertEquals("George",service.findById("owners",1).get("FIRST_NAME")); }
 @Test void update() {
  service.create("owners", "id, first_name", "?, ?", 101, "Ana");
  assertEquals(1,service.update("owners","first_name = ?","updated",101));
  assertEquals("updated",service.findById("owners",101).get("FIRST_NAME"));
 }
 @Test void delete() {
  service.create("owners", "id, first_name", "?, ?", 101, "Ana");
  assertEquals(1,service.delete("owners",101));
  assertEquals(0,service.count("owners",101));
 }
}
