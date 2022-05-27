package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.KhoaEntity;


public interface KhoaRepository extends  JpaRepository<KhoaEntity, String> {
	@Query(value="select * from khoa ", nativeQuery = true)
	List<KhoaEntity> getAllKhoaEntities();
	@Modifying
	@Query(value="SELECT * FROM khoa WHERE ma_khoa = :ma_khoa  ", nativeQuery = true)
	List<KhoaEntity> findKhoaEntityByID(@Param("ma_khoa") String ma_khoa);
}
