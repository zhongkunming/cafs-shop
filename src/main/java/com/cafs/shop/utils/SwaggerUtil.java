package com.cafs.shop.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import springfox.documentation.RequestHandler;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class SwaggerUtil {
    public SwaggerUtil() {
    }

    public static Predicate<RequestHandler> basePackages(final List<String> basePackages) {
        return (input) -> {
            return (Boolean) declaringClass(input).map(handlerPackage(basePackages)).orElse(true);
        };
    }

    private static Function<Class<?>, @Nullable Boolean> handlerPackage(final List<String> basePackages) {
        return (input) -> {
            Iterator<String> var2 = basePackages.iterator();

            boolean isMatch;
            do {
                if (!var2.hasNext()) {
                    return false;
                }

                String strPackage = var2.next();
                isMatch = input.getPackage().getName().startsWith(strPackage);
            } while(!isMatch);

            return true;
        };
    }

    private static Optional<Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }
}
