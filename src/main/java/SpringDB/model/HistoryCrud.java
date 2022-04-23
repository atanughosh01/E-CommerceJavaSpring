package SpringDB.model;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringDB.schema.History;

public interface HistoryCrud extends JpaRepository<History, Integer> {

}
