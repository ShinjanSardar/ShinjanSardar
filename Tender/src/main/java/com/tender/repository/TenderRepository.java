package com.tender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tender.entity.TenderData;
@Repository
public interface TenderRepository extends JpaRepository<TenderData, Long> {
	@Query(value = "SELECT lpad(tenderid, 2, 0) as tenderid,date,serialid,extention,tendername,workname FROM tender_data ORDER BY serialid DESC LIMIT 1", nativeQuery = true)
	public TenderData  getLastid();
}
