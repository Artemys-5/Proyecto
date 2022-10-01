package com.proyectoDesarrollo.Services;

import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Repository.IUsuarioRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServiceUsuario {

    private IUsuarioRepository userRepository;

    public ServiceUsuario(IUsuarioRepository rep){
        this.userRepository = rep;
    }

    //GET con POSTMAN
    public ArrayList<Usuario> selectAll(){
        return (ArrayList<Usuario>) this.userRepository.findAll();
    }


    //Metodo que recibe un parametro de tipo Usuario y devolverá una Response
    //POST con POSTMAN
    public Response createUser(Usuario user){
        Response response = new Response();

        if(!isValidEmailAdress(user.getEmail())){
            response.setCode(500);
            response.setMessage("Error, el correo de usuario no es invalido");
            return response;
        }

        if(user.getPassword().equals(null) || user.getPassword().equals("")){
            response.setCode(500);
            response.setMessage("Error, la contraseña suministrada está errada");
            return response;
        }

        ArrayList<Usuario> existe = this.userRepository.existeEmail(user.getEmail());

        if(existe != null && existe.size()>0){
            response.setCode(500);
            response.setMessage("Error, el usuario a crear ya existe");
            return response;
        }

        // ------  Añadido por el profe para tema de seguridad parece ------ //
        //BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        //user.setPassword(encrypt.encode(user.getPassword()));

        this.userRepository.save(user);
        //Configura el code con 200
        response.setCode(200);
        //Configura el mensaje de la respuesta.
        response.setMessage("Usuario registrado exitosamente");
        return response;
    }

    public Usuario selectById(int Id){
        Optional<Usuario> existe = this.userRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else{return null;}

    }

    public Response deleteUserById(int id){
        this.userRepository.deleteById(id);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("El ususario ha sido eliminado exitosamente");

        return response;
    }

    //public Response updateUsuario(int id){
    public Response updateUsuarioById(int id, Usuario dato){

        Response response = new Response();
        if(id<=0){
            response.setCode(500);
            response.setMessage("Error, el Id del usuario no es valido");
            return response;
        }
        Usuario existe = selectById(id);
        if(existe == null){
            response.setCode(500);
            response.setMessage("Error, el usuario no existe en la base de datos");
            return response;
        }
        existe.setEmail(dato.getEmail());
        this.userRepository.save(existe);
        response.setCode(200);
        response.setMessage("Usuario modificado exitosamente");

        return response;
    }



    public Response loginUsuario(Usuario data){

        Response response = new Response();
        if(!isValidEmailAdress(data.getEmail())){
            response.setCode(500);
            response.setMessage("Error, el usuario dado no es válido");
            return response;
        }

        if(data.getPassword().equals(null) || data.getPassword().equals("")){
            response.setCode(500);
            response.setMessage("Error, la contraseña no es valida");
            return response;
        }

        ArrayList<Usuario> existe = this.userRepository.validarCredenciales(data.getEmail(),data.getPassword());
        if(existe != null && existe.size()>0){
            response.setCode(200);
            response.setMessage("El Usuario ha sido autenticado de manera exitosa");
            return response;
        }

        response.setCode(500);
        response.setMessage("Error, sus datos son incorrectos");
        return response;

    }

    public boolean isValidEmailAdress(String email){

        boolean resultado = true;
        try{
            InternetAddress emailAdress = new InternetAddress(email);
            emailAdress.validate();
        }catch(AddressException exception){
            resultado = false;
        }

        return  resultado;
    }

}
