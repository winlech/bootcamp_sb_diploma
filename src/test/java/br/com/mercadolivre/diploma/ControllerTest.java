package br.com.mercadolivre.diploma;

import br.com.mercadolivre.diploma.Aluno.dto.StudentDTO;
import br.com.mercadolivre.diploma.Aluno.dto.SubjectDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void deve_RetornarUmDiploma() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10),
                new SubjectDTO("Português", 5)
        ));
        StudentDTO studentDTO = new StudentDTO("Wincenty", subjects);
        String payload = mapper.writeValueAsString(studentDTO);

        mock.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payload))
            .andExpect(status().isCreated());

    }
}
