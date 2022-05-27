package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.KhoaEntity;
import com.example.demo.entity.SinhVienEntity;

@Repository
@Transactional
public interface SinhVienRePository extends JpaRepository<SinhVienEntity, String>  {
	@Query(value="select * from sinhvien ", nativeQuery = true)
	List<SinhVienEntity> getAllSinhVienEntities();
	@Modifying
	@Query(value="INSERT INTO sinhvien (ma_sinh_vien, ten, ma_khoa, qq, nam_sinh) VALUES(:ma_sinh_vien, :ten, :ma_khoa, :qq, :nam_sinh)", nativeQuery = true)
	void insertSinhVienEntity(@Param("ma_sinh_vien") String ma_sinh_vien, @Param("ten") String ten, @Param("ma_khoa") KhoaEntity ma_khoa, @Param("qq") String qq, @Param("nam_sinh") int nam_sinh);
	@Modifying
	@Query(value="DELETE FROM sinhvien WHERE ma_sinh_vien = :ma_sinh_vien  ", nativeQuery = true)
	void deleteSinhVienEntity(@Param("ma_sinh_vien") String ma_sinh_vien);
	@Modifying
	@Query(value="SELECT * FROM sinhvien, khoa WHERE ma_sinh_vien = :ma_sinh_vien  ", nativeQuery = true)
	List<SinhVienEntity> findSinhVienEntityByID(@Param("ma_sinh_vien") String ma_sinh_vien);
	@Modifying
	@Query(value="UPDATE sinhvien  SET ten = :ten, ma_khoa = :ma_khoa , qq = :qq , nam_sinh = :nam_sinh WHERE ma_sinh_vien = :ma_sinh_vien", nativeQuery = true)
	void updateSinhVienEntity(@Param("ma_sinh_vien") String ma_sinh_vien, @Param("ten") String ten, @Param("ma_khoa") KhoaEntity ma_khoa, @Param("qq") String qq, @Param("nam_sinh") int nam_sinh);
}
