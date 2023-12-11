package br.com.biblioteca.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusProjectEnum {

    EM_ANALISE( "EM_ANALISE", "Em Analise"),
    ANALISE_REALIZADA("ANALISE_REALIZADA", "Analise Realizada"),
    ANALISE_APROVADA("ANALISE_APROVADA", "Analise Aprovada"),
    INICIADO("INICIADO", "Iniciado"),
    PLANEJADO("PLANEJADO", "Planejado"),
    EM_ANDAMENTO("EM_ANDAMENTO", "Em Andamento"),
    ENCERRADO("ENCERRADO", "Encerrado"),
    CANCELADO("CANCELADO", "Cancelado");

    private final String name;
    private final String description;


    public static StatusProjectEnum toEnum(String description) {
        return Arrays.stream(StatusProjectEnum.values()).filter(v->  v.getDescription().equals(description)).findFirst().orElse(null);
    }


}
