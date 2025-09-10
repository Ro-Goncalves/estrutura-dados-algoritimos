package br.com.rgbrainlabs.estruturadados.vetor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        // Given
        var vetor = new Vetor(1);

        // When & Then
        assertDoesNotThrow(() -> {
            vetor.adicionar("elemento");
        });
    }

    @Test
    void quandoAdicionarMaisElementosDoQueCapacidade_deveriaLancarExcecao() {
        // Given
        var vetor = new Vetor(1);
        vetor.adicionar("elemento");

        // When & Then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            vetor.adicionar("elemento");
        });
    }

    @Test
    void deveriaRetornarTamanho() {
        // Given
        var vetor = new Vetor(3);
        vetor.adicionar("elemento 1");
        vetor.adicionar("elemento 2");

        // When
        var retorno = vetor.tamanho();
        
        // Then
        assertEquals(2, retorno);
    }

    @Test
    void deveriaRetornarToString() {
        // Given
        var vetor = new Vetor(3);
        vetor.adicionar("elemento 1");
        vetor.adicionar("elemento 2");
        
        // When
        var retorno = vetor.toString();

        // Then
        assertEquals("[elemento 1, elemento 2]", retorno);
    }
}
