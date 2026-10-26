package com.gqs.aula.tdd;

import java.util.List;

/** Valida senhas conforme os requisitos do sistema. */
public final class ValidarSenha {

    private static final int TAMANHO_MINIMO = 8;
    private static final long DIGITOS_MINIMOS = 2;

    private static final String ERRO_TAMANHO =
            "A senha deve ter pelo menos 8 caracteres";
    private static final String ERRO_DIGITOS =
            "A senha deve conter pelo menos 2 dígitos";
    private static final String ERRO_MAIUSCULA =
            "A senha deve conter pelo menos uma letra maiuscula";
    private static final String ERRO_ESPECIAL =
            "A senha deve conter pelo menos um caractere especial";

    private ValidarSenha() {
    }

    /**
     * Valida uma senha e adiciona à lista os erros encontrados.
     *
     * @param senha senha a validar
     * @param erros lista que receberá os erros
     * @return true quando a senha atender a todas as regras
     */
    public static boolean validarSenha(String senha, List<String> erros) {
        erros.clear();

        if (senha.length() < TAMANHO_MINIMO) {
            erros.add(ERRO_TAMANHO);
        }

        if (!temDigitosSuficientes(senha)) {
            erros.add(ERRO_DIGITOS);
        }

        if (!temMaiuscula(senha)) {
            erros.add(ERRO_MAIUSCULA);
        }

        if (!temCaractereEspecial(senha)) {
            erros.add(ERRO_ESPECIAL);
        }

        return erros.isEmpty();
    }

    private static boolean temDigitosSuficientes(String senha) {
        long quantidade = senha.chars()
                .filter(caractere -> caractere >= '0' && caractere <= '9')
                .count();

        return quantidade >= DIGITOS_MINIMOS;
    }

    private static boolean temMaiuscula(String senha) {
        return senha.chars().anyMatch(Character::isUpperCase);
    }

    private static boolean temCaractereEspecial(String senha) {
        return senha.chars().anyMatch(
                caractere -> !Character.isLetterOrDigit(caractere)
                        && !Character.isWhitespace(caractere));
    }
}