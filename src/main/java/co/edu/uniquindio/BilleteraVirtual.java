package co.edu.uniquindio;//Clase billetera con sus respetivos atributos
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BilleteraVirtual {
    private String numero;
    private double saldo;
    private Usuario usuario;
    private List<Transaccion> transaccciones;

    public BilleteraVirtual() {
        this.numero = UUID.randomUUID().toString().substring(0, 10);
        this.saldo = 0;
        this.usuario = usuario;
        this.transaccciones = new ArrayList<>();
    }

    private String generarNumeroBilletera(){
        return String.valueOf(new Random().nextInt(900000000)+1000000000);
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void recargar(double monto) {
        if (monto <=0){
            throw new IllegalArgumentException("El monto debe ser un valor positivo");
        }
        saldo += monto;
    }

    public void transferir(BilleteraVirtual destino, double monto) {
        if(monto +200 > saldo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= (monto +200);
        destino.recargar(monto);
        transaccciones.add(new Transaccion("Transferencia",monto,destino.getNumero()));
    }

    public List<Transaccion> getTransaccciones() {
        return transaccciones;
    }

}

