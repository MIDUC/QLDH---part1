package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.LopEntity;
import com.example.demo.entity.SinhVienEntity;
import com.example.demo.entity.ThanhVienEntity;

public interface ThanhVienRepository extends JpaRepository<ThanhVienEntity, String> {
	@Query(value="select DISTINCT * from thanhvien ", nativeQuery = true)
	List<ThanhVienEntity> getAllThanhVienEntities();
	@Modifying
	@Query(value="SELECT DISTINCT * FROM thanhvien WHERE ma_thanh_vien = :ma_thanh_vien  ", nativeQuery = true)
	List<ThanhVienEntity> findThanhVienEntityByID(@Param("ma_thanh_vien") String ma_thanh_vien);
	@Modifying
	@Query(value="INSERT INTO thanhvien (ma_thanh_vien, ma_lop, ma_sinh_vien) VALUES(:ma_thanh_vien, :ma_lop, :ma_sinh_vien )", nativeQuery = true)
	void insertThanhVienEntity(@Param("ma_thanh_vien") String ma_thanh_vien, @Param("ma_lop") LopEntity ma_lop, @Param("ma_sinh_vien") SinhVienEntity ma_sinh_vien);
	@Modifying
	@Query(value="DELETE FROM thanhvien WHERE ma_thanh_vien = :ma_thanh_vien  ", nativeQuery = true)
	void deleteThanhVienEntity(@Param("ma_thanh_vien") String ma_thanh_vien);
	@Modifying
	@Query(value="UPDATE thanhvien SET ma_lop = :ma_lop, ma_sinh_vien = :ma_sinh_vien WHERE ma_thanh_vien = :ma_thanh_vien", nativeQuery = true)
	void updateThanhVienEntity(@Param("ma_thanh_vien") String ma_thanh_vien, @Param("ma_lop") LopEntity ma_lop, @Param("ma_sinh_vien") SinhVienEntity ma_sinh_vien);
	@Query(value="select sv.ma_sinh_vien from sinhvien sv, lop l where sv.ma_sinh_vien=?2 and l.ma_lop=?1", nativeQuery = true)
	String checkThanhVien(String msv, String ml);
}
