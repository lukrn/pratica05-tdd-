package com.gqs.aula.tdd;

import java.util.List;

public class ValidarSenha {

    public static boolean validarSenha(String senha, List<String> erros) {
        erros.clear();

        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        long quantidadeDigitos = senha.chars()
                .filter(c -> c >= '0' && c <= '9')
                .count();

        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        if (senha.chars().noneMatch(Character::isUpperCase)) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        boolean temCaractereEspecial = senha.chars()
                .anyMatch(c -> !Character.isLetterOrDigit(c)
                        && !Character.isWhitespace(c));

        if (!temCaractereEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        return erros.isEmpty();
    }
}