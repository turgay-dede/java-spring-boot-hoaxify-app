package com.hoaxifyapp.hoaxifyapp.business.utilities.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {
    String message() default "Kullanıcı adı mevcut";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
