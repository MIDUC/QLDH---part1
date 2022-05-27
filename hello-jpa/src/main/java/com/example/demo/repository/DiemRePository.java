package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DiemEntity;

@Repository
@Transactional
public interface DiemRePository extends JpaRepository<DiemEntity, Integer> {
	
	@Query(value="select * from tbldiem ", nativeQuery = true)
	List<DiemEntity> getAllDiemEntities();
	@Modifying
	@Query(value="SELECT * FROM tbldiem WHERE ma_diem = :ma_diem ", nativeQuery = true)
	List<DiemEntity> findDiemEntityByID(@Param("ma_diem") Integer ma_diem);
}
