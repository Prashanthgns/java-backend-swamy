package com.ani.patientmodule.controller;

import com.ani.patientmodule.domain.Patient;
import com.ani.patientmodule.dto.AppResponse;
import com.ani.patientmodule.dto.PatientDto;
import com.ani.patientmodule.service.PatientService;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RequestMapping("/pt")
@RestController
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping("/pt")
    public ResponseEntity<AppResponse<PatientDto>> registerPatient(@RequestBody PatientDto dto) {

        var svObj = service.registerPatient(dto);

        var response = new AppResponse<PatientDto>();
        response.setStatus("success");
        response.setMessage("Patient saved successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/pt1")
    public ResponseEntity<AppResponse<PatientDto>> updatePatientInformation(@RequestBody PatientDto dto) {

        PatientDto svObj1 = service.updatePatientInformation(dto);

        var response = new AppResponse<PatientDto>();
        response.setStatus("success");
        response.setMessage("Patient saved successfully");
        response.setBody(svObj1);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<AppResponse<Integer>> deletePatient(@PathVariable int id) {

        service.deletePatient(id);

        var response = new AppResponse<Integer>();
        response.setStatus("success");
        response.setMessage("Patient delete successfully");
        response.setBody(1);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{sa}/{ea}")//{sa}/{ea}
    public ResponseEntity<AppResponse<List>> ageBetween(@PathVariable int sa, @PathVariable int ea) {

        service.ageBetween(sa, ea);

        var response = new AppResponse<List>();
        response.setStatus("success");
        response.setMessage("Patient age successfully");
        response.setBody(service.ageBetween(sa, ea));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{stats}")
    public ResponseEntity<AppResponse<List>> allActivePatient(@PathVariable boolean stats) throws UnsatisfiedDependencyException {
        {

            service.allActivePatient(false);

            var response = new AppResponse<List>();
            response.setStatus("success");
            response.setMessage("Active Patient");
            response.setBody(service.allActivePatient(false));

            return ResponseEntity.ok(response);
        }
    }
}