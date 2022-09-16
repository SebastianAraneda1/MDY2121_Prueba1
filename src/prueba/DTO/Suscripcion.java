package prueba.DTO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Suscripcion {
    private Date FechaInicioSuscripcion;
    private String Equipo;
    private String Usuario;
    private int Abono;
    private int NumeroSuscripcion;

    public Suscripcion() {
        this.FechaInicioSuscripcion = new Date();
        this.Equipo = "";
        this.Abono = 0;
        this.NumeroSuscripcion = 0;
    }

    public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	public Date getFechaInicioSuscripcion() {
        return FechaInicioSuscripcion;
    }

    public void setFechaInicioSuscripcion(Date FechaInicioSuscripcion) {
        this.FechaInicioSuscripcion = FechaInicioSuscripcion;
    }

    public String getEquipo() {
        return Equipo;
    }

    public void setEquipo(String Equipo) {
        this.Equipo = Equipo;
    }

    public int getAbono() {
        return Abono;
    }

    public void setAbono(int Abono) {
        this.Abono = Abono;
    }

    public int getNumeroSuscripcion() {
        return NumeroSuscripcion;
    }

    public void setNumeroSuscripcion(int Correlativo) {
        this.NumeroSuscripcion = Correlativo;
    }
    
    int milDiez = 1010;
    
    public int crearNumero () {
    	int numero = milDiez;
    	milDiez =  milDiez + 10;
    	return numero;
    }
    
    public Suscripcion crearSuscripcion(Suscripcion sus, String opt, Usuario user) {
    	Suscripcion nuevaSus = sus;
    	nuevaSus.setNumeroSuscripcion(crearNumero());
		nuevaSus.setUsuario(user.getNombreUsuario());
    	switch (opt) {
			case "1": {
				nuevaSus.setAbono(actualizarPrecioAbono(10050, nuevaSus));
				nuevaSus.setEquipo(nuevaSus.getEquipo().concat("ARH11 $10.050; "));
				break;
			}
			case "2": {
				nuevaSus.setAbono(actualizarPrecioAbono(15100, nuevaSus));
				nuevaSus.setEquipo(nuevaSus.getEquipo().concat("MCH12 $15.100; "));
				break;
			}
			case "3": {
				nuevaSus.setAbono(actualizarPrecioAbono(13200, nuevaSus));
				nuevaSus.setEquipo(nuevaSus.getEquipo().concat("LCH13 $13.200; "));
				break;
			}
    	}
		
		return nuevaSus;
    }
    
    public int actualizarPrecioAbono(int monto, Suscripcion sus) {
    	int nuevoMonto = sus.getAbono() + monto;
    	return nuevoMonto;
    }
    
    public void mostrarSuscripciones(Suscripcion sus) {
    	
    	DecimalFormat formatea = new DecimalFormat("###,###,###.##");
    	
    	System.out.println("===============================\n" +
 	     		  		   "         SUSCRIPCIONES         \n" +
 	     		  		   "===============================\n" +
 	     		  		   "Numero: " + sus.getNumeroSuscripcion() +
 	     		  		   "Usuario: " + sus.getUsuario() +
 	     		  		   "Abono total: $" + formatea.format(sus.getAbono()) + 
 	     		  		   "Equipos: " + sus.getEquipo()
 	     		  		   );
    	
    }
    
}
