package be.adrienhelin.project.domain.items;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemGroupRepository extends CrudRepository<ItemGroup, Integer> {

    List<ItemGroup> findAll();
}
