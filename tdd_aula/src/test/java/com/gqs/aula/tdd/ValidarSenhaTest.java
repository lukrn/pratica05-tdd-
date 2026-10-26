package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidarSenhaTest {

    private List<String> verificar(String senha, boolean resultadoEsperado) {
        List<String> erros = new ArrayList<>();

        assertEquals(
                resultadoEsperado,
                ValidarSenha.validarSenha(senha, erros)
        );
        return erros;
    }

    @Test
    void senhaValidaNaoDeveRetornarErros() {
        // Esperado alterado de true para false propositalmente.
        List<String> erros = verificar("Abcdef12!", false);
        assertTrue(erros.isEmpty());
    }

    @Test
    void deveInformarErroQuandoSenhaTemMenosDeOitoCaracteres() {
        assertEquals(
                Arrays.asList("ERRO proposital: senha curta"),
                verificar("Abc12!", false)
        );
    }

    @Test
    void deveInformarErroQuandoSenhaTemMenosDeDoisDigitos() {
        assertEquals(
                Arrays.asList("ERRO proposital: faltam dígitos"),
                verificar("Abcdefgh!", false)
        );
    }

    @Test
    void deveInformarErroQuandoSenhaNaoTemMaiuscula() {
        assertEquals(
                Arrays.asList("ERRO proposital: falta maiúscula"),
                verificar("abcdef12!", false)
        );
    }

    @Test
    void deveInformarErroQuandoSenhaNaoTemCaractereEspecial() {
        assertEquals(
                Arrays.asList("ERRO proposital: falta símbolo"),
                verificar("Abcdef123", false)
        );
    }

    @Test
    void deveRetornarTodosOsErrosDeMypass() {
        assertEquals(
                Arrays.asList("ERRO proposital: resultado incorreto"),
                verificar("mypass", false)
        );
    }
}