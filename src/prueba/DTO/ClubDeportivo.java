package prueba.DTO;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


public class ClubDeportivo {
    private String Codigo;
    private String Nombre;
    private String Fundador;
    private LocalDate FechaFundacion;
    private String Pais;
    private String Lema;
    private String Deporte;
    private String colores;
    private int ValorSuscripcion;
    private int correlativo = 10;
    Scanner sc = new Scanner(System.in);
    //Constructor
    public ClubDeportivo() {
        this.Codigo = "";
        this.Nombre = "";
        this.Fundador = "";
        this.FechaFundacion = null;
        this.Pais = "";
        this.Lema = "";
        this.Deporte = "";
        this.colores = "";
        this.ValorSuscripcion = 0;
    }
    //GET / SET
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        if( validarCodigo(Codigo) ){
           this.Codigo = Codigo; 
        }else{
            System.out.println("Codigo incorrecto");
        }
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFundador() {
        return Fundador;
    }

    public void setFundador(String Fundador) {
        this.Fundador = Fundador;
    }

    public LocalDate getFechaFundacion() {
        return FechaFundacion;
    }

    public void setFechaFundacion(LocalDate FechaFundacion) {
        this.FechaFundacion = FechaFundacion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getLema() {
        return Lema;
    }

    public void setLema(String Lema) {
        this.Lema = Lema;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String Deporte) {
        this.Deporte = Deporte;
    }
    
    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = this.colores.concat(colores + ", ");
    }

    public int getValorSuscripcion() {
        return ValorSuscripcion;
    }

    public void setValorSuscripcion(int ValorSuscripcion) {
        this.ValorSuscripcion = ValorSuscripcion;
    }
    
    public int getCorrelativo() {
		return correlativo;
	}
    
	public void setCorrelativo(int correlativo) {
		this.correlativo = correlativo;
	}
	
    public boolean validarCodigo (String codigo){
        boolean codigoValido = false;
        if(codigo.length() > 4){
            if (codigo.substring(0,2).toUpperCase().matches("[A-Z]*")){
                if (Integer.parseInt(codigo.substring(3)) > 9){
                    codigoValido = true;
                }else{
                    System.out.println("Codigo Incorrecto");
                }
            }else {
                System.out.println("Codigo Incorrecto");
            }
        }else {
            System.out.println("Largo del Codigo Incorrecto");
        }
        return codigoValido;  
    }
    
    public String crearCodigo ( String nombreClub, String deporte ) {
    	
    	String codigoCreado = "";
    	
    	// Obtener primeras dos letras del nombre del club
    	codigoCreado = nombreClub.substring(0, 2);
    	// Obtener la inicial del deporte
    	codigoCreado =  codigoCreado.concat(deporte.substring(0, 1)).toUpperCase();
    	// Concatenar correlativo
    	codigoCreado = codigoCreado.concat(String.valueOf(getCorrelativo()));
    	// Sumar 1 al correlativo para que incremente
    	setCorrelativo(getCorrelativo() + 1);
    	
    	return codigoCreado;
    }
    
    
    public void mostratClubes (ClubDeportivo[] listaClubes) {
    	DecimalFormat formatea = new DecimalFormat("###,###,###.##");
    	System.out.println("===============================\n"+
		  	     "           CLUBES              \n"+
		  		 "===============================\n");
		for (int i = 0; i < listaClubes.length; i++) {
		  System.out.println( (i+1) + ". Codigo: " + listaClubes[i].getCodigo() + "\n" +
				  			  (i+1) + ". Nombre: " + listaClubes[i].getNombre() + "\n" +
				  			  (i+1) + ". Lema: " + listaClubes[i].getLema() + "\n" +
				  			  (i+1) + ". Valor Suscripcion: $" + formatea.format(listaClubes[i].getValorSuscripcion()) + "\n" +
				  			  (i+1) + ". Colores: " + listaClubes[i].getColores() + "\n"
				  			);
		}
    }
    
    public ClubDeportivo[] actualizarNombreClub(ClubDeportivo[] listaClubes) {
    	ClubDeportivo[] nuevaLista = listaClubes;
    	
    	System.out.println("Indique el club a actualizar");
		  for (int i = 0; i < listaClubes.length; i++) {
			System.out.println((i+1) +  ". " + listaClubes[i].getNombre());
		  }
		  String optClub = sc.nextLine();
		  try {
			  System.out.println("Ingrese el nuevo nombre");
			  String nuevoNombre = sc.next();
			  switch (optClub) {
					case "1": {
						nuevaLista[0].setNombre(nuevoNombre);
						nuevaLista[0].setCodigo(crearCodigo(nuevoNombre, nuevaLista[0].getDeporte()));
						System.out.println("Cambio de nombre exitoso");
						break;
					}
					case "2": {
						nuevaLista[1].setNombre(nuevoNombre);
						nuevaLista[1].setCodigo(crearCodigo(nuevoNombre, nuevaLista[1].getDeporte()));
						System.out.println("Cambio de nombre exitoso");
						break;
					}
					case "3": {
						nuevaLista[2].setNombre(nuevoNombre);
						nuevaLista[2].setCodigo(crearCodigo(nuevoNombre, nuevaLista[2].getDeporte()));
						System.out.println("Cambio de nombre exitoso");
						break;
					}
			  }
		  } catch (Exception e) {
			System.out.println("Opcion invalida");
		  }
    	
    	
    	return nuevaLista;
    }
    
    
    
   
}
