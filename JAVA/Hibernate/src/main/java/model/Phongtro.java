package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phongtro database table.
 * 
 */
@Entity
@NamedQuery(name="Phongtro.findAll", query="SELECT p FROM Phongtro p")
public class Phongtro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String giaDien;

	@Lob
	private String giaNuoc;

	@Lob
	private String giaThang;

	@Id
	private String id;

	private String maPhong;

	public Phongtro() {
	}

	public String getGiaDien() {
		return this.giaDien;
	}

	public void setGiaDien(String giaDien) {
		this.giaDien = giaDien;
	}

	public String getGiaNuoc() {
		return this.giaNuoc;
	}

	public void setGiaNuoc(String giaNuoc) {
		this.giaNuoc = giaNuoc;
	}

	public String getGiaThang() {
		return this.giaThang;
	}

	public void setGiaThang(String giaThang) {
		this.giaThang = giaThang;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaPhong() {
		return this.maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

}