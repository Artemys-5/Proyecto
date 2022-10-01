package com.proyectoDesarrollo.Repository;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1 and u.password = ?2")
    ArrayList<Usuario> validarCredenciales(String email, String password);

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    ArrayList<Usuario> existeEmail(String email);

}

