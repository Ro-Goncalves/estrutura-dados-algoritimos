package br.com.rgbrainlabs.estruturadados.vetor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class VetorTest {

    @Test
    void deveriaCriarVetor() {
        assertDoesNotThrow(() -> {
            new Vetor(10);
        });
    }
}
