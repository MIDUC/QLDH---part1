package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.LopEntity;

public interface LopRePository extends JpaRepository<LopEntity, String> {
	@Query(value="select * from lop ", nativeQuery = true)
	List<LopEntity> getAllLopEntities();
	@Modifying
	@Query(value="SELECT * FROM lop WHERE ma_lop = :ma_lop  ", nativeQuery = true)
	List<LopEntity> findLopEntityByID(@Param("ma_lop") String ma_lop);
}
