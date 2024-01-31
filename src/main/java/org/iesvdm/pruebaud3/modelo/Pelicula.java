package org.iesvdm.pruebaud3.modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    private Integer id;
    @NotBlank(message = "{}")
    @Min(value = 3, message = "{}")
    private String titulo;
    @Max(value = 300 , message = "{}")
    private String descripcion;
    private Date fechaLanzamiento;
    private Integer idIdioma;
    private Integer duracionAlquiler;
    @Min(value = 0)
    private Double rentalRate;
    @Min(value = 1 , message = "{}")
    private Integer duracion;
    @Min(value = 20 , message = "{}")
    private Double replacementCost;
    private Date ultimaActualizacion;

}
