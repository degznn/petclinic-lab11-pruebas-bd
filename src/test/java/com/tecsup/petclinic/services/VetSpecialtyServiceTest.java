package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class VetSpecialtyServiceTest {
 @Autowired ClinicTableService service;
 @Test void assign() {
  assertEquals(0,service.findSpecialtiesByVet(1).size());
  assertEquals(1,service.assignSpecialty(1,1));
  assertEquals(1,service.findSpecialtiesByVet(1).size());
 }
 @Test void findByVet() {
  assertEquals(2,service.findSpecialtiesByVet(3).size());
 }
 @Test void remove() {
  service.assignSpecialty(1,1);
  assertEquals(1,service.removeSpecialty(1,1));
  assertTrue(service.findSpecialtiesByVet(1).isEmpty());
 }
}
