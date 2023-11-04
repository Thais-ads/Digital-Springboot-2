package br.com.fiap.Media.Aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AulasService {

    @Autowired
    AulasRepository repository;


    public List<Aulas> findAll(){
        return repository.findAll();
    }


    public boolean delete(Long id) {

      var aula = repository.findById(id);

      if(aula.isEmpty()){
          return false;
      }
         repository.deleteById(id);
            return true;
    }
}
