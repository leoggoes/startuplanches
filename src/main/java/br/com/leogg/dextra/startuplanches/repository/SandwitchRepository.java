package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.leogg.dextra.startuplanches.models.Sandwitch;

public interface SandwitchRepository extends JpaRepository<Sandwitch,Long>{
  public Sandwitch findByName(String name);
}
