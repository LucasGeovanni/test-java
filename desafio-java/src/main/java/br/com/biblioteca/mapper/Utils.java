package br.com.biblioteca.mapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Utils {

    public static Date toDate(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
