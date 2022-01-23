package com.ani.patientmodule.service;

import com.ani.patientmodule.domain.Patient;
import com.ani.patientmodule.dto.PatientDto;

import javax.security.auth.login.AccountNotFoundException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PatientService {
    public PatientDto registerPatient(PatientDto dto);

    public PatientDto updatePatientInformation(PatientDto dto);

    public void deletePatient(int id);

    public List<PatientDto> ageBetween(int sa, int ea);

    public List<PatientDto> allActivePatient(boolean stats);
}
