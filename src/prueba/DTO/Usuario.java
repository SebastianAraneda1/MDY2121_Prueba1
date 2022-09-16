package prueba.DTO;

import java.text.SimpleDateFormat;
import static java.time.temporal.ChronoUnit.YEARS;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Usuario {
    private int Id = 1000;
    private String NombreCompleto;
    private int Rut;
    private String Dv;
    private LocalDate FechanNacimiento;
    private int Telefono;
    private String Mail;
    private String NombreUsuario;
    private String Contrasenia;
    Scanner sc = new Scanner(System.in);
    
 //Constructor
    public Usuario() {
        this.NombreCompleto = "";
        this.Rut = 0;
        this.Dv = "";
        this.FechanNacimiento = null;
        this.Telefono = 0;
        this.Mail = "";
        this.NombreUsuario = "";
        this.Contrasenia = "";
    }
    //GET and SET
    public int getId() {
        return Id;    
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public int getRut() {
        return Rut;
    }

    public void setRut(int Rut, char Dv) {
        if(this.validarRut(Rut, Dv)){
            this.Rut = Rut;
            this.Dv = Dv+"";
        }
    }

    public String getDv() {
        return Dv;
    }

    public void setDv(String Dv) {
        this.Dv = Dv;
    }

    public LocalDate getFechanNacimiento() {
        return FechanNacimiento;
    }

    public void setFechanNacimiento(LocalDate FechanNacimiento) {
    	if (validarMayoriaEdad(FechanNacimiento)) {
            this.FechanNacimiento = FechanNacimiento;
    	}
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        String tel = Integer.toString(Telefono);
        if(tel.length() >= 8 && tel.substring(0, 2).equals("56")){
            this.Telefono = Telefono;
        }else{
            System.out.println("Debe empezar con 56 y tener 8 caracteres minimo");
        }
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        if(Mail.length() > 5 && Mail.contains("@")){
            this.Mail = Mail;
        }
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        if(NombreUsuario.length() >= 4){
            this.NombreUsuario = NombreUsuario;
        }else{
            System.out.println("El nombre debe poseer mas de 4 caracteres");
        }
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        if (validarContrasenia(Contrasenia)){ 
            this.Contrasenia = Contrasenia;
        }
    }
    
    //Validacion
    public boolean validarRut(int rut, char dv) {
        boolean validacion = false;
        try {
            int m = 0, s = 1;
            for (; rut != 0; rut /= 10) {
                s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    public boolean validarContrasenia (String contrasenia){
        boolean contraseniaValida = false;
        if(contrasenia.length() > 5){
            String contraseniaMin = contrasenia.toLowerCase();
            if (contraseniaMin != contrasenia & contrasenia.matches(".*[0-9].*")){    
                contraseniaValida = true;
            }else {
                System.out.println("Contrasenia debe tener al menos mayuscula y numero");
            }
        }else {
            System.out.println("Contrasenia Incorrecta");
        }
        return contraseniaValida;  
    }
    
    int mil  = 1000;
    
    public int crearId () {
    	int id = mil;
    	mil++;
    	return id;
    }
    
    public boolean validarMayoriaEdad(LocalDate fechaNac) {
    	boolean mayorEdad = false;
    	long annos = YEARS.between(fechaNac, LocalDate.now());
    	if (annos > 17) {
    		mayorEdad = true;
    	}
    	else {
    		System.out.println("El usuario debe ser mayor de edad");
    	}
    	return mayorEdad;
    }
    
    public Usuario logIn(Usuario[] listaUsuarios) {
    	Usuario user = new Usuario();
    	System.out.println("******LOGIN******\n");
  	  	System.out.println("Ingrese su usuario: ");
        String userName =  sc.nextLine();
        String password = "";
        int index = 0;
	  	  for (int i = 0; i < listaUsuarios.length; i++) {
				if ( listaUsuarios[i].getNombreUsuario().equals(userName) ) {
					password = listaUsuarios[i].getContrasenia();
					index = i;
				}
				if (i == listaUsuarios.length - 1 && password.isEmpty()) {
					System.out.println("El usuario ingresado no existe");
				}
          }
          if (!password.isEmpty()) {
              System.out.println("Ingrese su contrasena: ");
              String passIngresada =  sc.nextLine();
              if (passIngresada.equals(password)) {
            	  user = listaUsuarios[index];
              }
              else {
            	  System.out.println("Contrasena incorrecta");
              }
          }
          
          return user;
    }
    
    public boolean cambiarPass(Usuario usuario) {
    	boolean cambioExitoso = false;
    	System.out.println("Ingrese la nueva contrasena");
  	  	String nuevaPass = sc.nextLine();
  	  	if (validarContrasenia(nuevaPass)) {
  	  	  	usuario.setContrasenia(nuevaPass);
  	  	  	cambioExitoso = true;
  	  	}
  	  	return cambioExitoso;
    }
   
}
