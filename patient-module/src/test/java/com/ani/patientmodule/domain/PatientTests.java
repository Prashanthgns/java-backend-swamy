package com.ani.patientmodule.domain;

import com.ani.patientmodule.dto.PatientDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientTests {
    @DisplayName("Domain : Checking Object Creation")
    @Test
    void testObjectCreation() {
        var abc = new Patient();
        Assertions.assertNotNull(abc);
    }

    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var abc = new Patient();
        abc.setStatus(true);
        abc.setMobile(9855622231l);
        abc.setAge(10);
        abc.setLastVisited(LocalDate.of(2021,1,1));
        abc.setName("abc");
        abc.setId(10);

        Assertions.assertEquals(10, abc.getAge());
        Assertions.assertEquals(LocalDate.of(2021,1,1), abc.getLastVisited());
        Assertions.assertEquals("abc", abc.getName());
        Assertions.assertEquals(10, abc.getId());
        Assertions.assertEquals(true,abc.isStatus());
        Assertions.assertEquals(9855622231l,abc.getMobile());
    }
//    @DisplayName("Domain : checking list")
//    @Test
//    void testObjectlist(){
//        List<PatientDto> dto1 = new ArrayList<>();
//        List<Patient> pa = new ArrayList<>();
//
//        }
//        Assertions.(10, .getAge());
//        Assertions.assertEquals(LocalDate.of(2021,1,1), pa.getLastVisited());
//        Assertions.assertEquals("abc", pa.getName());
//        Assertions.assertEquals(10, pa.getId());
//        Assertions.assertEquals(true,pa.isStatus());
//        Assertions.assertEquals(9855622231l,pa.getMobile());
//    }
}
