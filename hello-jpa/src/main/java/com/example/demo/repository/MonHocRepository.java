package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.KhoaEntity;
import com.example.demo.entity.MonHocEntity;


@Repository
@Transactional
public interface MonHocRepository  extends JpaRepository<MonHocEntity, String>{
	@Query(value="select * from monhoc ", nativeQuery = true)
	List<MonHocEntity> getAllmonhocEntities();
	@Modifying
	@Query(value="INSERT INTO monhoc (ma, ten, khoa) VALUES(:ma, :ten, :khoa)", nativeQuery = true)
	void insertmonhocEntity(@Param("ma") String ma, @Param("ten") String ten, @Param("khoa") KhoaEntity khoa);
	@Modifying
	@Query(value="DELETE FROM monhoc WHERE ma = :ma  ", nativeQuery = true)
	void deletemonhocEntity(@Param("ma") String ma);
	@Modifying
	@Query(value="SELECT * FROM monhoc WHERE ma = :ma  ", nativeQuery = true)
	List<MonHocEntity> findmonhocEntityByID(@Param("ma") String ma);
	@Modifying
	@Query(value="UPDATE monhoc  SET ten = :ten , khoa = :khoa WHERE ma = :ma", nativeQuery = true)
	void updatemonhocEntity(@Param("ma") String ma, @Param("ten") String ten, @Param("khoa") KhoaEntity khoa);
}
