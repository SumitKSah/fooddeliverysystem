package com.food.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.app.entity.ComponentDetailsEntity;

@Repository
public interface ComponentDetailsRepository extends JpaRepository<ComponentDetailsEntity, Long> {

	<S extends ComponentDetailsEntity> S save(final S componentDetails);

	<S extends ComponentDetailsEntity> List<S> save(final Iterable<S> componentDetails);

	ComponentDetailsEntity findByComponentName(final String componentName);

	ComponentDetailsEntity findByComponentIdentifier(final String componentIdentifier);
//
//	@Query("SELECT new com.food.app.bean.ComponentDetailsBean(c.componentName,c.componentIdentifier) FROM ComponentDetailsEntity c WHERE c.componentName = (:componentName)")
//	ComponentDetailsBean getByComponentName(@Param("componentName") final String componentName);
//
//	@Query("SELECT new com.food.app.bean.ComponentDetailsBean(c.componentName,c.componentIdentifier) FROM ComponentDetailsEntity c WHERE c.componentName != (:componentName)")
//	List<ComponentDetailsBean> getByComponentNameNotIn(@Param("componentName") final String componentName);

}
