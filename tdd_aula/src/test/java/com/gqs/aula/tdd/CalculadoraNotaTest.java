package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
// os testes vêm aqui
@Test
void deveSomarAsTresNotas() {
CalculadoraNota calc = new CalculadoraNota();
double resultado = calc.calcularNotaFinal(20, 20, 30);
assertEquals(70, resultado);
}
@Test
void deveSomarOutrasNotas() {
CalculadoraNota calc = new CalculadoraNota();
double resultado = calc.calcularNotaFinal(10, 15, 25);
assertEquals(50, resultado);
}
@Test
void deveAprovarComNota70() {
CalculadoraNota calc = new CalculadoraNota();
assertTrue(calc.estaAprovadoPorNota(70));
}

@Test
void deveReprovarComNota69() {
CalculadoraNota calc = new CalculadoraNota();
assertFalse(calc.estaAprovadoPorNota(69));
}
@Test 
void deveRejeitarA1MaiorQue30() {
CalculadoraNota calc = new CalculadoraNota();
assertThrows(IllegalArgumentException.class,
() -> calc.calcularNotaFinal(35, 20, 30));
}
@Test 
void deveRejeitarA2MaiorQue30() {
CalculadoraNota calc = new CalculadoraNota();
assertThrows(IllegalArgumentException.class,
() -> calc.calcularNotaFinal(20, 35, 30));
}
@Test 
void deveRejeitarA3MaiorQue40() {
CalculadoraNota calc = new CalculadoraNota();
assertThrows(IllegalArgumentException.class,
() -> calc.calcularNotaFinal(20, 20, 45));
}
void MaximasValem() {
CalculadoraNota calc = new CalculadoraNota();
assertThrows(IllegalArgumentException.class,
() -> calc.calcularNotaFinal(30, 30, 40));
}
}
