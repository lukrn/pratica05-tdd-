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
        List<String> erros = verificar("Abcdef12!", true);
        assertTrue(erros.isEmpty());
    }
    @Test
    void deveInformarErroQuandoSenhaTemMenosDeOitoCaracteres() {
        assertEquals(
                Arrays.asList("A senha deve ter pelo menos 8 caracteres"),
                verificar("Abc12!", false)
        );
    }
    @Test
    void deveInformarErroQuandoSenhaTemMenosDeDoisDigitos() {
        assertEquals(
                Arrays.asList("A senha deve conter pelo menos 2 dígitos"),
                verificar("Abcdefgh!", false)
        );
    }
    @Test
    void deveInformarErroQuandoSenhaNaoTemMaiuscula() {
        assertEquals(
                Arrays.asList("A senha deve conter pelo menos uma letra maiuscula"),
                verificar("abcdef12!", false)
        );
    }
    @Test
    void deveInformarErroQuandoSenhaNaoTemCaractereEspecial() {
        assertEquals(
                Arrays.asList("A senha deve conter pelo menos um caractere especial"),
                verificar("Abcdef123", false)
        );
    }
    @Test
    void deveRetornarTodosOsErrosDeMypass() {
        assertEquals(
                Arrays.asList(
                        "A senha deve ter pelo menos 8 caracteres",
                        "A senha deve conter pelo menos 2 dígitos",
                        "A senha deve conter pelo menos uma letra maiuscula",
                        "A senha deve conter pelo menos um caractere especial"
                ),
                verificar("mypass", false)
        );
    }
}