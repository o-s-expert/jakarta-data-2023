package os.expert.examples;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, String> {

    List<Developer> findByLanguage(String language);
}
