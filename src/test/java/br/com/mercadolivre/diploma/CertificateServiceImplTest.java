package br.com.mercadolivre.diploma;

import br.com.mercadolivre.diploma.Aluno.dto.ResponseDTO;
import br.com.mercadolivre.diploma.Aluno.dto.StudentDTO;
import br.com.mercadolivre.diploma.Aluno.dto.SubjectDTO;
import br.com.mercadolivre.diploma.Aluno.services.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CertificateServiceImplTest {

    private ValidationService analyzeNotes;
    private List<SubjectDTO> subjects;

    @BeforeEach
    void init() {
        int note1 = 5;
        int note2 = 10;
        analyzeNotes = new ValidationService();
        subjects = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", note1),
                new SubjectDTO("Português", note2)
                )
        );
    }

    @Test
    void analyzeNotesEqualTest() {

        StudentDTO studentDTO = new StudentDTO("Wincenty", subjects);
        ResponseDTO expectedResult = new ResponseDTO(studentDTO, 7.5, "Sua media foi de 7.5");

        ResponseDTO result = analyzeNotes.execute(studentDTO);

        assertEquals(result.toString(), expectedResult.toString());
    }

    @Test
    void calculateAverageTest() {
        double expectedResult = 7.5;
        double result = analyzeNotes.calculateAverage(subjects);

        assertEquals(result, expectedResult);
    }

    @Test
    void writeDiplomaTest() {
        StudentDTO studentDTO = new StudentDTO("Wincenty", subjects);
        ResponseDTO expectedDiploma = new ResponseDTO(studentDTO, 7.5, "Sua media foi de 7.5");

        ResponseDTO result = analyzeNotes.writeDiploma(studentDTO, 7.5);

        assertEquals(result.toString(), expectedDiploma.toString());
    }

    @Test
    void withHonorsTest() {
        boolean result = analyzeNotes.withHonors(10);

        assertTrue(result);
    }

    @Test
    void analyzeNotesNotEqualTest(){
        StudentDTO studentDTO = new StudentDTO("Wincenty", subjects);
        ResponseDTO expectedResult = new ResponseDTO(studentDTO, 10, "Sua media foi de 10");

        ResponseDTO result = analyzeNotes.execute(studentDTO);

        assertNotEquals(result.toString(), expectedResult.toString());
    }

    @Test
    void calculateAverageNotEqualTest() {
        double expectedResult = 10;
        double result = analyzeNotes.calculateAverage(subjects);

        assertNotEquals(result, expectedResult);
    }

    @Test
    void writeDiplomaNotEqualTest() {
        StudentDTO studentDTO = new StudentDTO("Wincenty", subjects);
        ResponseDTO expectedDiploma = new ResponseDTO(studentDTO, 10, "Sua media foi de 10");

        ResponseDTO result = analyzeNotes.writeDiploma(studentDTO, 7.5);

        assertNotEquals(result.toString(), expectedDiploma.toString());
    }

    @Test
    void withHonorsNotEqualTest() {
        boolean result = analyzeNotes.withHonors(7);

        assertFalse(result);
    }


}
