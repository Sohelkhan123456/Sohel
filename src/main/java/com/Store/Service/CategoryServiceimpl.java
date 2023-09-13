package com.Store.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Store.Repository.Categoryrepo;
import com.Store.models.Category;

@Service
public class CategoryServiceimpl implements CategoryService {

	@Autowired
	Categoryrepo repo ;

	@Override
	public List<Category> getCategories() {
		
		return repo.findAll();
	}

	public List<Category> addCategories(Category category) {
		try {
			repo.save(category);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return repo.findAll();
	}

	@Override
	public List<Category> updateCategories(String category, int id) {
		if(repo.findById(id).get()!=null && repo.findById(id).isPresent()) {
			Category cat = repo.findById(id).get();
			cat.setCategory(category);
			repo.save(cat);
			repo.findAll();
		}else {
			
			return null;
		}
		return null;
		
	}

	@Override
	public List<Category> deletecategories(int id) {
		if(repo.findById(id).isPresent()==false) {
			return null ;
		}else {
			repo.deleteById(id);
			return repo.findAll();
		}
	
	}

	@Override
	public Optional<Category> findById(int id) {
		return repo.findById(id);
		
	}

	
	
	
	
}
