package br.com.biblioteca.model.dto;

import br.com.biblioteca.model.enuns.RiskEnum;
import br.com.biblioteca.model.enuns.StatusProjectEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class ProjectRequest {

    private Long id;

    @NonNull
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedEndDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String description;

    private StatusProjectEnum status;

    private Float budget;

    private RiskEnum risk;

    @NonNull
    private Long manager;
}
