package br.com.walllet.usuario.unit;

import br.com.walllet.usuario.constraint.validator.CpfValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class CpfValidatorTest {

    @Spy
    private CpfValidator validator;

    @BeforeEach
    public void init() {

        this.validator = new CpfValidator();
    }

    @ParameterizedTest
    @MethodSource("obterCpfInvalido")
    void dadoCpfInvalidoDeveRetornarFalse(String cpfOuCnpj) {

        assertFalse(this.validator.isValid(cpfOuCnpj, null));
    }

    @ParameterizedTest
    @MethodSource("obterCpfValido")
    void dadoCpfValidoDeveRetornarTrue(String cnpjOuCnpj) {

        assertTrue(this.validator.isValid(cnpjOuCnpj, null));
    }

    public static Stream<String> obterCpfInvalido() {
        return Stream.of(
                "630256130001,00",
                "63025613000100",
                "6302561300010",
                "abcdss",
                "00000000000000",
                "11111111111111",
                "22222222222222",
                "33333333333333",
                null,
                "01234567891",
                "11111111111",
                "111.111.111,11",
                "99999999999",
                "",
                "000.000.000-00",
                "000.000.000-001",
                "000000000001",
                "0000000"
        );
    }

    public static Stream<String> obterCpfValido() {

        return Stream.of(
                "01234567890",
                "012.345.678-90"
        );
    }
}
