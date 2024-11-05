package com.iqac.service;

import com.iqac.model.PhDPapers;
import com.iqac.repository.PhDPapersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhDPapersService {
    @Autowired
    private PhDPapersRepository phdPapersRepository;

    public List<PhDPapers> getAllPapers() {
        return phdPapersRepository.findAll();
    }

    public PhDPapers getPaperById(Long id) {
        return phdPapersRepository.findById(id).orElse(null);
    }

    public PhDPapers savePaper(PhDPapers phdPapers) {
        return phdPapersRepository.save(phdPapers);
    }

    public void deletePaper(Long id) {
        phdPapersRepository.deleteById(id);
    }
}
