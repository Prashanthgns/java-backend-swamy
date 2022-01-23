package com.ani.patientmodule.repository;

import com.ani.patientmodule.domain.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientRepositoryTests {
    @Autowired
    private PatientRepository repository;

    @DisplayName("Patient Repo : Creating Patient")
    @Test
    public void testCreatePatient() {

        var abc = new Patient();
        abc.setId(565);
        abc.setName("abc");
        abc.setAge(56);
        abc.setLastVisited(LocalDate.now());

        repository.save(abc);
    }
}
