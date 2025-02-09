package nl.lhdev.lhcommerce.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// @Entity
// @Table(name = "tb_mensalidade")
public class Mensalidade {
    private Long id;
    private Long contrato_id;
    private MensalStatus MensalStatus;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;

}
