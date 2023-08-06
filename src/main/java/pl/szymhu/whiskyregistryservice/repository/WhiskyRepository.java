package pl.szymhu.whiskyregistryservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import pl.szymhu.whiskyregistryservice.model.Whisky;

@Component
public interface WhiskyRepository extends MongoRepository<Whisky, String> {

  List<Whisky> findAllByAged(int aged);

  List<Whisky> findAllByType(String type);

  @Query("{name: {$regex: ?0}}")
  List<Whisky> findByNameContains(String name);
}
