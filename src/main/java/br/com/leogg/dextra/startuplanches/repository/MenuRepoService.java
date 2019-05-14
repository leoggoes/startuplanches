package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import java.util.Optional;
import java.util.List;
import br.com.leogg.dextra.startuplanches.models.Menu;

@Service
public class MenuRepoService{
  @Autowired
  private MenuRepository repository;

  public Menu findByName(String name){
    return repository.findByName(name);
  }

  public Optional<Menu> findById(Long id){
    return repository.findById(id);
  }

  public List<Menu> findAll(){
    return repository.findAll(/*new Sort(Sort.Direction.ASC,"id")*/);
  }

  public Menu save(Menu menu){
    return repository.saveAndFlush(menu);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }
}
