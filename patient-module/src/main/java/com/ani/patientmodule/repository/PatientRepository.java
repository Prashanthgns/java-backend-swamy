package com.ani.patientmodule.repository;

import com.ani.patientmodule.domain.Patient;
import com.ani.patientmodule.dto.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Modifying // allows firing insert, update and delete queries
    @Query(value = "insert into patient values(id,name,mobile,age,status,last_visited)", nativeQuery = true)
    void registerPatient();

    @Modifying // allows firing insert, update and delete queries
    @Query(value = "update patient set id,name,mobile,age,status,last_visited where id = :id", nativeQuery = true)
    void updatePatientInformation(@Param("id") int id);

    @Modifying // allows firing insert, update and delete queries
    @Query(value = "delete from patient where id = :id", nativeQuery = true)
    void deletePatient(@Param("id") int id);

    List<Patient> findByAgeBetween(int sa,int ea);

    @Query(value = "SELECT * FROM Patient WHERE status = :stats", nativeQuery = true)
    void allActivePatient(@Param("stats") boolean stats);
    List<Patient> findByStatusTrue();
}

