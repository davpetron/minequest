package es.etg.daw.dwes.minequest.tarea.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.RECORD_COMPONENT })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoTareaValidator.class)
@Documented
public @interface TipoTarea {

    String message() default "{tarea.valid.tipo.invalido}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}