package com.dio.live.model;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Usuario {
    @Id
    private Long id;
    private String nome;
    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @OneToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;


}
