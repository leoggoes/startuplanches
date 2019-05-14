package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import java.util.Optional;
import java.util.List;
import br.com.leogg.dextra.startuplanches.models.Sandwitch;

@Service
public class SandwitchRepoService{
  @Autowired
  private SandwitchRepository repository;

  public Sandwitch findByName(String name){
    return repository.findByName(name);
  }

  public Optional<Sandwitch> findById(Long id){
    return repository.findById(id);
  }

  public List<Sandwitch> findAll(){
    return repository.findAll(/*new Sort(Sort.Direction.ASC,"id")*/);
  }

  public Sandwitch save(Sandwitch sandwitch){
    return repository.saveAndFlush(sandwitch);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }
}
