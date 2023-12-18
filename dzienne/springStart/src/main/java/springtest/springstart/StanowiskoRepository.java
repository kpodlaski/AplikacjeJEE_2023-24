package springtest.springstart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springtest.springstart.model.Stanowisko;

import java.util.List;

@Repository
public interface StanowiskoRepository extends CrudRepository<Stanowisko,Integer> {

    public List<Stanowisko> findStanowiskoByNazwaStartingWith(String start);

    public List<Stanowisko> findStanowiskoByNazwa(String nazwa);

}
