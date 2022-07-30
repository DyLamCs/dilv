package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phong database table.
 * 
 */
@Entity
@NamedQuery(name="Phong.findAll", query="SELECT p FROM Phong p")
public class Phong implements Serializable {
	private static final long serialVersionUID = 1L;

	private double dienTich;

	@Id
	private String id;

	private String loaiPhong;

	private String maPhong;

	private String tenPhong;

	private int trangThai;

	public Phong() {
	}

	public double getDienTich() {
		return this.dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoaiPhong() {
		return this.loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getMaPhong() {
		return this.maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return this.tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}