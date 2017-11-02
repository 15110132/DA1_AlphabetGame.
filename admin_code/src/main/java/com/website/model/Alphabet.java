package com.website.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alphabet", catalog = "project1")
public class Alphabet implements Serializable {
	private static final long serialVersionID = 1L;

	private int id;
	private String letter;
	private byte[] imagedata;
	private String imgEnc64;
	private byte[] image2data;
	private String img2Enc64;
	private byte[] sounddata;
	private String soundEnc64;
	
	public Alphabet() {
		// TODO Auto-generated constructor stub
	}

	
	public Alphabet(int id, String letter, byte[] imagedata, String imgEnc64, byte[] image2data, String img2Enc64,
			byte[] sounddata, String soundEnc64) {
	
		this.id = id;
		this.letter = letter;
		this.imagedata = imagedata;
		this.imgEnc64 = imgEnc64;
		this.image2data = image2data;
		this.img2Enc64 = img2Enc64;
		this.sounddata = sounddata;
		this.soundEnc64 = soundEnc64;
	}


	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "LETTER", length = 50)
	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	@Column(name = "I1_DATA", length = 16777215)
	public byte[] getImagedata() {
		return imagedata;
	}

	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}

	@Column(name = "I1_DATA64", length = 16777215)
	public String getImgEnc64() {
		return imgEnc64;
	}

	public void setImgEnc64(String imgEnc64) {
		this.imgEnc64 = imgEnc64;
	}
	
	@Column(name = "I2_DATA", length = 16777215)
	public byte[] getImage2data() {
		return image2data;
	}


	public void setImage2data(byte[] image2data) {
		this.image2data = image2data;
	}

	@Column(name = "I2_DATA64", length = 16777215)
	public String getImg2Enc64() {
		return img2Enc64;
	}


	public void setImg2Enc64(String img2Enc64) {
		this.img2Enc64 = img2Enc64;
	}

	@Column(name = "SOUND_DATA", length = 16777215)
	public byte[] getSounddata() {
		return sounddata;
	}

	public void setSounddata(byte[] sounddata) {
		this.sounddata = sounddata;
	}

	@Column(name = "SOUND_DATA64", length = 16777215)
	public String getSoundEnc64() {
		return soundEnc64;
	}

	public void setSoundEnc64(String soundEnc64) {
		this.soundEnc64 = soundEnc64;
	}
	
	
}
