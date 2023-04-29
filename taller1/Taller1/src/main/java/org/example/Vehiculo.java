package org.example;

import javax.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    @Column(name = "ANIO_FABRICACION")
    private Integer anioFabricacion;
    @Column(name = "NRO_CHASIS")
    private String nroChasis;

    @Column(name = "NRO_MOTOR")
    private String nroMotor;
    private String color1;
    private String color2;
    private Double avaluo;
    private boolean prendado;
    public Vehiculo() {
    }
    public Vehiculo(Integer id, String placa, Integer anioFabricacion, String nroChasis, String nroMotor,
                    String color1, String color2, Double avaluo, boolean prendado) {
        this.id = id;
        this.placa = placa;
        this.anioFabricacion = anioFabricacion;
        this.nroChasis = nroChasis;
        this.nroMotor = nroMotor;
        this.color1 = color1;
        this.color2 = color2;
        this.avaluo = avaluo;
        this.prendado = prendado;
    }

}
