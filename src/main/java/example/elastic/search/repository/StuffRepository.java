package example.elastic.search.repository;

import example.elastic.search.model.Stuff;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository extends ElasticsearchRepository<Stuff,String> {
}
