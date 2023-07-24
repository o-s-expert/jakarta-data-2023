package os.expert.examples;

import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface BeerRepository extends PageableRepository<Beer, String> {


    Page<Beer> findByHopOrderByName(String hope, Pageable pageable);
    Page<Beer> findByMaltOrderByName(String malt, Pageable pageable);

    Page<Beer> findByMaltAndHopOrderByName(String malt, String hop, Pageable pageable);
}
