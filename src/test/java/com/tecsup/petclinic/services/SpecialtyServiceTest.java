package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class SpecialtyServiceTest {
 @Autowired ClinicTableService service;
 @Test void create() {
  assertEquals("radiology", service.findById("specialties", 1).get("NAME"));
  assertEquals(1, service.create("specialties", "id, name", "?, ?", 101, "cardiology"));
  assertEquals("cardiology", service.findById("specialties",101).get("NAME"));
 }
 @Test void findById() { assertEquals("radiology",service.findById("specialties",1).get("NAME")); }
 @Test void update() {
  service.create("specialties", "id, name", "?, ?", 101, "cardiology");
  assertEquals(1,service.update("specialties","name = ?","updated",101));
  assertEquals("updated",service.findById("specialties",101).get("NAME"));
 }
 @Test void delete() {
  service.create("specialties", "id, name", "?, ?", 101, "cardiology");
  assertEquals(1,service.delete("specialties",101));
  assertEquals(0,service.count("specialties",101));
 }
}
