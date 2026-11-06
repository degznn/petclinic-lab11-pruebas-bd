package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class TypeServiceTest {
 @Autowired ClinicTableService service;
 @Test void create() { assertEquals("cat",service.findById("types",1).get("NAME")); assertEquals(1,service.create("types", "id, name", "?, ?", 101, "ferret")); assertEquals("ferret",service.findById("types",101).get("NAME")); }
 @Test void findById() { assertEquals("cat",service.findById("types",1).get("NAME")); }
 @Test void update() { service.create("types", "id, name", "?, ?", 101, "ferret"); assertEquals(1,service.update("types","name = ?","updated",101)); assertEquals("updated",service.findById("types",101).get("NAME")); }
 @Test void delete() { service.create("types", "id, name", "?, ?", 101, "ferret"); assertEquals(1,service.delete("types",101)); assertEquals(0,service.count("types",101)); }
}
