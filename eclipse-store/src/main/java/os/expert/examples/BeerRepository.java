package os.expert.examples;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface BeerRepository extends PageableRepository<EclipseStoreBeer, String> {
}
