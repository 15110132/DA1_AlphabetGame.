package com.website.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dao.AlphabetDAO;
import com.website.model.Alphabet;

@Service("alphabetService")
public class AlphabetService {
	@Autowired
	AlphabetDAO alphadao;
	
	@Transactional
	public List getAllalphabet(){
		return alphadao.getAll();
		
	}
	@Transactional
	public Alphabet getAlphabetById(int id){
		return alphadao.getByID(id);
	}
	
	@Transactional
	public void addAlphabet(Alphabet pro){
		alphadao.add(pro);
	}
	
	@Transactional
	public Alphabet updateAlphabet(Alphabet pro){
		return alphadao.update(pro);
	}
	
	@Transactional
	public void deleteAlphabet(int id){
		alphadao.delete(id);
	}

}
