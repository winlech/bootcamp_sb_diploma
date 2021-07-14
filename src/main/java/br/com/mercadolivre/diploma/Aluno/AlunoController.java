package br.com.mercadolivre.diploma.Aluno;

import br.com.mercadolivre.diploma.Aluno.dto.ResponseDTO;
import br.com.mercadolivre.diploma.Aluno.dto.StudentDTO;
import br.com.mercadolivre.diploma.Aluno.entities.Aluno;
import br.com.mercadolivre.diploma.Aluno.entities.Diploma;
import br.com.mercadolivre.diploma.Aluno.services.AlunoService;
import br.com.mercadolivre.diploma.Aluno.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AlunoController {

    private final AlunoService alunoService;
    private final ValidationService validationService;

    @Autowired
    public AlunoController(AlunoService alunoService, ValidationService validationService) {
        this.alunoService = alunoService;
        this.validationService = validationService;
    }

    @PostMapping
    public ResponseEntity<Diploma> getAluno(@RequestBody Aluno aluno) {
        return new ResponseEntity<>(alunoService.getDiploma(aluno), HttpStatus.OK);
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<ResponseDTO> analyzeNotes(@Valid @RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(validationService.execute(studentDTO), HttpStatus.CREATED);
    }
}
