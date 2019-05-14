package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import java.util.Optional;
import java.util.List;
import br.com.leogg.dextra.startuplanches.models.Ingredient;

@Service
public class IngredientRepoService{
  @Autowired
  private IngredientRepository repository;

  public Ingredient findByName(String name){
    return repository.findByName(name);
  }

  public Optional<Ingredient> findById(Long id){
    return repository.findById(id);
  }

  public List<Ingredient> findAll(){
    return repository.findAll(/*new Sort(Sort.Direction.ASC,"id")*/);
  }

  public Ingredient save(Ingredient ingredient){
    return repository.saveAndFlush(ingredient);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }
}
