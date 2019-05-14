package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.leogg.dextra.startuplanches.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{
  public Menu findByName(String name);
}
