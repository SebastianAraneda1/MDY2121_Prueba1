package prueba;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import prueba.DTO.ClubDeportivo;
import prueba.DTO.Suscripcion; 
import prueba.DTO.Usuario;

public class Principal {
	
	  public static LocalDate formatearFecha ( String fecha ) {
	      	LocalDate fechaFormateada;
	      	DateTimeFormatter formatoDeEntrada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	      	fechaFormateada = LocalDate.parse(fecha, formatoDeEntrada);
	      	//System.out.println(fechaFormateada);
	      	return fechaFormateada;
      }

      @SuppressWarnings("null")
	public static void main(String[] args) {
    	  
    	  Scanner sc = new Scanner(System.in);
    	  DecimalFormat formatea = new DecimalFormat("###,###,###.##");
    	  
    	  // Lista usuarios
    	  Usuario[] listaUsuarios = new Usuario[3];
          
          //Usuarios
          Usuario a = new Usuario();
          a.setId(a.crearId());
          a.setNombreCompleto("Pepe Roni");
          a.setNombreUsuario("dcog");
          a.setContrasenia("Afds22231");
          a.setRut(17782300, '7');
          a.setTelefono(561245678);
          a.setFechanNacimiento(formatearFecha("10-06-1992"));
          a.setMail("david.cogiolle@gmail.com");
          listaUsuarios[0] = a;
          
          Usuario b = new Usuario();
          b.setId(a.crearId());
          b.setNombreCompleto("Jorge Nitales");
          b.setNombreUsuario("ggft");
          b.setContrasenia("G1ovanniGg34");
          b.setRut(18244584, '3');
          b.setTelefono(568765432);
          b.setFechanNacimiento(formatearFecha("10-08-1990"));
          b.setMail("gerr.adere@live.cl");
          listaUsuarios[1] = b;

          Usuario c = new Usuario();
          c.setId(a.crearId());
          c.setNombreCompleto("Penelope Zones");
          c.setNombreUsuario("ggft");
          c.setContrasenia("5534Gato33");
          c.setRut(11126615, '8');
          c.setTelefono(568766552);
          c.setFechanNacimiento(formatearFecha("11-09-1965"));
          c.setMail("sergio.villanueva@gmail.com");
          listaUsuarios[2] = c;
          
          /*
          System.out.println("===============================\n"+
			  	     		 "           Usuarios            \n"+
			  		 		 "===============================\n");
		  for (int i = 0; i < listaUsuarios.length; i++) {
			  System.out.println( "Codigo: " + listaUsuarios[i].getId() + "\n" +
					  			  "Nombre: " + listaUsuarios[i].getNombreUsuario() + "\n" +
					  			  "Lema: " + listaUsuarios[i].getMail() + "\n" +
					  			  "Valor Suscripcion: " + listaUsuarios[i].getContrasenia() + "\n"
					  			);
		  }
		  */
          
          // Lista clubes
          ClubDeportivo[] listaClubes = new ClubDeportivo[3];
          
          // Clubes          
          ClubDeportivo club1 = new ClubDeportivo();
          club1.setNombre("Arsenal de Coquimbo");
          club1.setDeporte("Handball");
          club1.setLema("Cañones a los puertos");
          club1.setFundador("Fabian Araneda");
          club1.setPais("Chile");
          club1.setColores("Amarillo");
          club1.setColores("Rojo");
          club1.setValorSuscripcion(10050);
          club1.setFechaFundacion(formatearFecha("10-06-1992"));
          club1.setCodigo(club1.crearCodigo(club1.getNombre(), club1.getDeporte()));
          listaClubes[0] = club1;

          ClubDeportivo club2 = new ClubDeportivo();
          club2.setNombre("Manquehue City");
          club2.setDeporte("Handball");
          club2.setLema("Vivir y Fuerza");
          club2.setFundador("Emilia Araneda");
          club2.setPais("USA");
          club2.setColores("Celeste");
          club2.setColores("Blanco");
          club2.setValorSuscripcion(15100);
          club1.setFechaFundacion(formatearFecha("10-08-2015"));
          club2.setCodigo(club1.crearCodigo(club2.getNombre(), club2.getDeporte()));
          listaClubes[1] = club2;

          ClubDeportivo club3 = new ClubDeportivo();
          club3.setNombre("Los Cóndores Unidos");
          club3.setDeporte("Handball");
          club3.setLema("Desde lo alto al sol");
          club3.setFundador("Rodrigo Araneda");
          club3.setPais("Chile");
          club3.setColores("Amarillo");
          club3.setColores("Naranjo");
          club3.setValorSuscripcion(13200);
          club1.setFechaFundacion(formatearFecha("26-10-2019"));
          club3.setCodigo(club1.crearCodigo(club3.getNombre(), club3.getDeporte()));
          listaClubes[2] = club3;
          
          boolean salir = false, logeado = false, esAdmin = false;
          String rol = "";
    	  Usuario user = new Usuario();
          Suscripcion suscripcion = new Suscripcion();
          
          while(!salir) {
        	  try {
            	  if (rol.isEmpty()) {
                	  System.out.println("******Selecione Modo******");
                      System.out.println("1. USUARIO");
                      System.out.println("2. ADMIN");
                      rol = sc.nextLine();
                      switch (rol) {
        					case "1": {
        						esAdmin = false;
        						break;
        					}
        					case "2": {
        						esAdmin = true;
        						break;
        					}
        			  }
            	  }
        	  } catch (Exception e) {
        		  System.out.println("Opcion invalida");
        	  }
              
              if (!logeado && !esAdmin) {
            	  user = user.logIn(listaUsuarios);
            	  logeado = user.getId() > 0 ? true : false;
              }
              else {
            	  System.out.println("******MENU******");
                  System.out.println("1. Cambiar contrasena");
                  System.out.println("2. Suscribirse a un club");
                  System.out.println("3. Ver suscripciones");
                  if (esAdmin) {
                      System.out.println("4. Cambiar nombre de club");
                  }
                  System.out.println("5. Salir"); 
                  System.out.println("*******************");
                  String opt = sc.nextLine();
                  
                  try {
					
                	  switch (opt) {
		                  case "1": {
		                	  boolean cambioExitoso = user.cambiarPass(user);
		                	  if (cambioExitoso) {
		                		  System.out.println("Cambio de contrasena exitoso");
		                	  }else {
		                		  System.out.println("Error al cambiar la contrasena");
		                	  }
      						break;
		                  }
		                  case "2": {
		                	  club1.mostratClubes(listaClubes);
					           
					           if (suscripcion.getNumeroSuscripcion() > 0) {
					        	   System.out.println("===============================\n"+
				         			  	     		  "         SUSCRIPCIONES         \n"+
				         			  		 		  "===============================\n"+
				         			  		 		  suscripcion.getEquipo() + "\n"+
				         			  		 		  "Abono total: $" + formatea.format(suscripcion.getAbono()) + "\n"
					        			   			 );
					        	   
					           }
					          
					          System.out.println("Seleccione el club a suscribir");
					          String clubOpt = sc.nextLine();
					          
					          suscripcion = suscripcion.crearSuscripcion(suscripcion, clubOpt, user);
      						break;
					          
						  }// FIN CASE 2
		                  case "3": {
		                	  if (suscripcion.getNumeroSuscripcion() > 0) {
			                	  suscripcion.mostrarSuscripciones(suscripcion);
		                	  }
		                	  else {
		                		  System.out.println("No se han encontrado siscripciones \n");
		                	  }
      						break;
		                  }
		                  case "4": {
		                	  if (!esAdmin) {
		                		  System.out.println("Opcion invalida");
		                	  }
		                	  else {
		                		  listaClubes = club1.actualizarNombreClub(listaClubes);
		                	  }
      						break;
		                  }
		                  case "5": {
		                	  salir = true;
		                  }
	                  
                	  }// FIN SWITCH CASE MENU
                	  
                  } catch (Exception e) {
                	  System.out.println("Opcion invalida");
                  }
              } // FIN ELSE LOGEADO
          } // FIN WHILE
    }    
}
