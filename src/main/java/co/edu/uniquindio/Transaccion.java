package co.edu.uniquindio;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaccion {
    private String id;
    private LocalDateTime fecha;
    private double monto;
    private Categoria categoria;
    private BilleteraVirtual origen;
    private BilleteraVirtual destino;

    public Transaccion(String tipo, double monto, String billeteraDestino) {
        this.id = UUID.randomUUID().toString();
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.categoria = categoria;
        this.origen = origen;
        this.destino = destino;


    }

    public String getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

}
