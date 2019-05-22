package edu.mum.waa.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class PresentOrFutureValidator
        implements ConstraintValidator<PresentOrFuture, LocalDate>{

    public final void initialize(final PresentOrFuture annotation) {}

    public final boolean isValid(final LocalDate value,
                                 final ConstraintValidatorContext context) {

       LocalDate today= LocalDate.now();


        // Your date must be after today or today (== not before today)
        return !value.isAfter(today) || value.isBefore(today);

    }
}