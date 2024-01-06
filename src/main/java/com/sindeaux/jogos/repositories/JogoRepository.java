package com.sindeaux.jogos.repositories;

import com.sindeaux.jogos.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {
}
