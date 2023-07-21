package os.expert.examples;

import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends PageableRepository<EclipseStoreBeer, String> {


    Page<EclipseStoreBeer> findByHopOrderByName(String hope, Pageable pageable);
    Page<EclipseStoreBeer> findByMaltOrderByName(String malt, Pageable pageable);

    Page<EclipseStoreBeer> findByMaltAndHopOrderByName(String malt, String hop, Pageable pageable);
}
