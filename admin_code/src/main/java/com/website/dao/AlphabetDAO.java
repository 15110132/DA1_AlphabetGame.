package com.website.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.model.Alphabet;
import com.website.model.Alphabet;

@Repository
public class AlphabetDAO {
	@Autowired
	private SessionFactory sessionfactory;

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public List getAll() {
		Session session = this.sessionfactory.getCurrentSession();
		List alphaList = session.createQuery("from Alphabet").list();
		return alphaList;
	}
	public Alphabet getByID(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		Alphabet Alphabet = (Alphabet) session.get(Alphabet.class, new Integer(id));
		return Alphabet;
	}

	public Alphabet add(Alphabet alpha) {
		Session session = this.sessionfactory.getCurrentSession();
		session.persist(alpha);
		return alpha;
	}

	public Alphabet update(Alphabet alpha) {
		Session session = this.sessionfactory.getCurrentSession();
		session.update(alpha);
		return alpha;
	}

	public void delete(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		Alphabet alphabet = (Alphabet) session.load(Alphabet.class, new Integer(id));
		if (alphabet != null) {
			session.delete(alphabet);
		}
	}
	

}
