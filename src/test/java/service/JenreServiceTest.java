package service;

import dto.JenreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JenreServiceTest {

    @Test
    void exist() {
        JenreDTO jenreDTO=new JenreDTO(1, "Rock");

        jenreDTO.getJenreName();
        Assertions.assertEquals("Rock", jenreDTO.getJenreName());
    }

    @Test
    void exist2() {
        JenreDTO jenreDTO=new JenreDTO(1, "Rock");
        jenreDTO.getJenreName();
        Assertions.assertNotEquals(" ", jenreDTO.getJenreName());
    }

    @Test
    void exist3() {
        JenreDTO jenreDTO=new JenreDTO(1, "Rock");
        jenreDTO.getJenreName();
        Assertions.assertNotEquals("Jazz", jenreDTO.getJenreName());
    }
}