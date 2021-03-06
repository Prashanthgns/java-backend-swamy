package com.ani.patientmodule.service;

import com.ani.patientmodule.domain.Patient;
import com.ani.patientmodule.dto.PatientDto;
import com.ani.patientmodule.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public PatientDto registerPatient(PatientDto dto) {

        var pt = new Patient();
        pt.setName(dto.getName());
        pt.setMobile(dto.getMobile());
        pt.setAge(dto.getAge());
        pt.setStatus(dto.getStatus());
        pt.setLastVisited(dto.getLastVisited());
        repository.save(pt);

        return dto;
    }

    @Override
    public PatientDto updatePatientInformation(PatientDto dto) {

        Patient pa = new Patient();
        pa.setId(dto.getId());
        pa.setName(dto.getName());
        pa.setMobile(dto.getMobile());
        pa.setAge(dto.getAge());
        pa.setStatus(dto.getStatus());
        pa.setLastVisited(dto.getLastVisited());

        Patient update = repository.save(pa);

        return new PatientDto(update.getId(), update.getName(), update.getMobile(), update.getAge(), update.isStatus(), update.getLastVisited());
    }

    @Override
    public void deletePatient(int id) {
        repository.deletePatient(id);
    }

    @Override
    public List<PatientDto> ageBetween(int sa, int ea) {
        List<Patient> patients = repository.findByAgeBetween(sa,ea);
        List<PatientDto> dtos = new ArrayList<>();
        for(int i = 0; i < patients.size(); i++) {

            Patient patient = patients.get(i);
            PatientDto dto = new PatientDto(
                    patient.getId(),
                    patient.getName(),
                    patient.getMobile(),
                    patient.getAge(),
                    patient.isStatus(),
                    patient.getLastVisited()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<PatientDto> allActivePatient(boolean stats) throws IllegalArgumentException {
        List<Patient> patients = repository.findByStatusTrue();
        List<PatientDto> dtos = new ArrayList<>();
        for(int i = 0; i < patients.size(); i++) {

            Patient patient = patients.get(i);
            PatientDto dto = new PatientDto(
                    patient.getId(),
                    patient.getName(),
                    patient.getMobile(),
                    patient.getAge(),
                    patient.isStatus(),
                    patient.getLastVisited()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
