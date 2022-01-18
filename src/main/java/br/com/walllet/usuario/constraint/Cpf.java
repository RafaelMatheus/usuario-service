package br.com.walllet.usuario.constraint;

import br.com.walllet.usuario.constraint.validator.CpfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = CpfValidator.class
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {
    String message() default "{javax.validation.constraints.Cpf.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
