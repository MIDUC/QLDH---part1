package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.GiangVienEntity;
import com.example.demo.entity.KhoaEntity;

@Repository
@Transactional
public interface GiangVienRePository extends JpaRepository<GiangVienEntity, String>{
	
	@Query(value="select * from giangvien ", nativeQuery = true)
	List<GiangVienEntity> getAllGiangVienEntities();
	@Modifying
	@Query(value="INSERT INTO giangvien (ma_giang_vien, ten, ma_khoa) VALUES(:ma_giang_vien, :ten, :ma_khoa)", nativeQuery = true)
	void insertGiangVienEntity(@Param("ma_giang_vien") String ma_giang_vien, @Param("ten") String ten, @Param("ma_khoa") KhoaEntity ma_khoa);
	@Modifying
	@Query(value="DELETE FROM giangvien WHERE ma_giang_vien = :ma_giang_vien  ", nativeQuery = true)
	void deleteGiangVienEntity(@Param("ma_giang_vien") String ma);
	@Modifying
	@Query(value="SELECT * FROM giangvien WHERE ma_giang_vien = :ma_giang_vien ", nativeQuery = true)
	List<GiangVienEntity> findGiangVienEntityByID(@Param("ma_giang_vien") String ma);
	@Modifying
	@Query(value="UPDATE giangvien  SET ten = :ten, ma_khoa = :ma_khoa WHERE ma_giang_vien = :ma_giang_vien", nativeQuery = true)
	void updateGiangVienEntity(@Param("ma_giang_vien") String ma_giang_vien, @Param("ten") String ten, @Param("ma_khoa") KhoaEntity ma_khoa);
}
