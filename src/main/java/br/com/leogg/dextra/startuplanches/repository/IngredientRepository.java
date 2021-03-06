package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.leogg.dextra.startuplanches.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long>{
  public Ingredient findByName(String name);
}
