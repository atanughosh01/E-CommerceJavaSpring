package SpringDB.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SpringDB.schema.Apparel;

public interface ApparelCrud extends JpaRepository<Apparel, Integer> {
	List<Apparel> findByAid(int aid);

	/** 
	 * %?1% is a regex for the search-quesry string
	 * That means the following query returns only those items-strings
	 * that our searched string is a substring of
	 */
	@Query(value = "SELECT * FROM apparel WHERE brand LIKE %?1% OR category LIKE %?1%", nativeQuery = true)
	List<Apparel> findBySearch(String str);

	List<Apparel> findAllByOrderByPriceAsc();

	List<Apparel> findAllByOrderByPriceDesc();

	List<Apparel> findAllByOrderByTypeAsc();

	List<Apparel> findAllByOrderByTypeDesc();
}
