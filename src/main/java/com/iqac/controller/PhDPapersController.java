package com.iqac.controller;

import com.iqac.model.PhDPapers;
import com.iqac.service.PhDPapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/phd-papers")
public class PhDPapersController {

    @Autowired
    private PhDPapersService phdPapersService;

    @GetMapping
    public List<PhDPapers> getAllPapers() {
        return phdPapersService.getAllPapers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhDPapers> getPaperById(@PathVariable Long id) {
        PhDPapers paper = phdPapersService.getPaperById(id);
        return paper != null ? ResponseEntity.ok(paper) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PhDPapers createPaper(@RequestBody PhDPapers phdPapers) {
        return phdPapersService.savePaper(phdPapers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaper(@PathVariable Long id) {
        phdPapersService.deletePaper(id);
        return ResponseEntity.noContent().build();
    }
}
