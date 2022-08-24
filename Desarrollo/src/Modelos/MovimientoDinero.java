package Modelos;

public class MovimientoDinero {

    private float monto;
    private boolean estadoMonto; // true corresponde a montos positivos y false para negativos
    private String concepto;
    private String usuario;


    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public boolean getEstadoMonto() {
        return estadoMonto;
    }

    public void setEstadoMonto(boolean estadoMonto) {
        this.estadoMonto = estadoMonto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
