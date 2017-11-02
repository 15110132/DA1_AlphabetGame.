package com.website.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.website.model.Alphabet;

import com.website.service.AlphabetService;

@Controller
public class AlphabetController {
	@Autowired
	AlphabetService alphabetservice;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getProducts(HttpServletRequest request,Model model) {
		List<Alphabet> letters = alphabetservice.getAllalphabet();
		model.addAttribute("loa", letters);
		return "showAll";
	}
	@RequestMapping(value = "/newAlphabet", method = RequestMethod.GET, headers = "Accept=application/json")
	public String viewAddAlphabet(Model model) {
		Alphabet alphabet = new Alphabet();
		model.addAttribute("alphabet", alphabet);
		return "addAlphabet";
	}
	@RequestMapping(value = "/addAlphabet", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addProduct(@RequestParam("alphaID") int id, @RequestParam("letter") String letter,
			@RequestParam("img1") MultipartFile file1, @RequestParam("img2") MultipartFile file2,
			@RequestParam("sound") MultipartFile filesound) {
		try {
			Alphabet alphabet;
			if (id == 0) {
				alphabet = buildAlphabet(new Alphabet(), letter,
						file1.getBytes(), file2.getBytes(), filesound.getBytes());
				alphabetservice.addAlphabet(alphabet);

			} else {
				alphabet = buildAlphabet(this.alphabetservice.getAlphabetById(id),letter
						, file1.getBytes(), file2.getBytes(), filesound.getBytes());
				alphabetservice.addAlphabet(alphabet);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/getAll";
	}
	
	
	private Alphabet buildAlphabet(Alphabet alphabet, String letter,
			byte[] data1, byte[] data2, byte[] sound) throws IOException {
		
		byte[] imgByte = Files.readAllBytes(new File("D:/JavaWEB/project1/src/main/webapp/resource/images/images.jpg").toPath());
		
		if (data1 != null && data1.length > 0) {
			
			alphabet.setImagedata(data1);
			// encode to 64bit img data
			byte[] encode1 = Base64Utils.encode(data1);
			String base64Encode1 = new String(encode1, "UTF-8");
			alphabet.setImgEnc64(base64Encode1);
		}
		else{
			byte[] encode1 = Base64Utils.encode(imgByte);
			String base64Encode1 = new String(encode1, "UTF-8");
			alphabet.setImgEnc64(base64Encode1); 
		}
		if (data2 != null && data2.length > 0) {
			alphabet.setImage2data(data2);
			byte[] encode2 = Base64Utils.encode(data2);
			String base64Encode2 = new String(encode2, "UTF-8");
			alphabet.setImg2Enc64(base64Encode2);
		}
		else{
			byte[] encode2 = Base64Utils.encode(imgByte);
			String base64Encode2 = new String(encode2, "UTF-8");
			alphabet.setImg2Enc64(base64Encode2);

		}
		if (sound != null && sound.length > 0) {
			alphabet.setSounddata(sound);
			byte[] encodeSound = Base64Utils.encode(sound);
			String base64EncodeSound = new String(encodeSound, "UTF-8");
			alphabet.setSoundEnc64(base64EncodeSound);
		}
		else{
			alphabet.setSoundEnc64(null);
		}
		
		return alphabet;
	}

}
