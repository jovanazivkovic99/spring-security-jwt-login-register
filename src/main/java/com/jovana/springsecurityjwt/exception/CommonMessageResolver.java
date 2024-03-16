package com.jovana.springsecurityjwt.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonMessageResolver {
    private final MessageSource messageSource;

    public final String get(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public final String get(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
