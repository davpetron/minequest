package es.etg.daw.dwes.minequest.tarea.infraestructure.web.validation;

import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoTareaValidator implements ConstraintValidator<TipoTarea, String> {

    public static final Set<String> TIPOS = Set.of("Construcción", "Minería", "Recolección",
            "Granjas", "Redstone", "Exploración", "Decoración", "Combate");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank())
            return true;

        return TIPOS.contains(value);
    }
}