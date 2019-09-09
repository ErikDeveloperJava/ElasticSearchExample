package example.elastic.search.repository;

import example.elastic.search.model.Address;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends ElasticsearchRepository<Address,String> {

    Optional<Address> findById(String id);

    List<Address> findByName(String name);
}