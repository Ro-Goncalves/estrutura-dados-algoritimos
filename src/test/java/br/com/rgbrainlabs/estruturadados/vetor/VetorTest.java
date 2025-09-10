package br.com.rgbrainlabs.estruturadados.vetor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class VetorTest {

    @Test
    void deveriaCriarVetor() {
        assertDoesNotThrow(() -> {
            new Vetor(10);
        });
    }

    @Test
    void deveriaAdicionarElemento() {
        var vetor = new Vetor(1);
        assertDoesNotThrow(() -> {
            vetor.adicionar("elemento");
        });
    }

    @Test
    void quandoAdicionarMaisElementosDoQueCapacidade_deveriaLancarExcecao() {
        var vetor = new Vetor(1);
        vetor.adicionar("elemento");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            vetor.adicionar("elemento");
        });
    }
}
