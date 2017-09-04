package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
