package br.com.fiap.Media.Aula;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="Aulas")
public class Aulas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank()
    public String title;

    @Size(min = 30)
    public String description;

    @Min(1) @Max(100)
    public Integer score;

    @Min(0) @Max(100)
    public Integer status;


    
}
