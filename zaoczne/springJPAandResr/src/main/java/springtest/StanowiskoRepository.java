package springtest;

import org.springframework.stereotype.Repository;
import springtest.model.Stanowisko;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface StanowiskoRepository extends CrudRepository<Stanowisko, Integer> {

    public List<Stanowisko> findByNazwaStartingWith(String nameStart);
}
