package by.itstep.hospital.service;

import by.itstep.hospital.model.Patient;
import by.itstep.hospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{

    PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return patientRepository.existsById(id);
    }

    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> findPaginated(int pageNumber, int pageSize, String sortField, String sortDir) {
        Sort sort = null;
        if (sortDir.equalsIgnoreCase("asc")){
            sort = Sort.by(sortField).ascending();
        }
        else{
            sort = Sort.by(sortField).descending();
        }
        
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return this.patientRepository.findAll(pageable);
    }
}
