package com.ani.patientmodule.service;

import com.ani.patientmodule.domain.Patient;
import com.ani.patientmodule.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class PatientServiceTests {
    @Mock
    private PatientRepository repository;

    @InjectMocks
    private PatientService service = new PatientServiceImpl();


   // @Test
   // void testSize() {
//        Mockito.when(
//                repository.findAll()
//        ).thenReturn(
//                List.of(
//                        new Patient((1, "abc", LocalDate.of(2021,1,1), 10,9855622231l,true)),
//                new Patient((2, "pqr", LocalDate.of(2021,1,2), 20,7985562223l,false))
//                );
//
//        var dtos = service;
//        Assertions.assertEquals(2, dtos);
   // }
}
