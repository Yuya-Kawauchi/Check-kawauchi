package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BeansEntity;
import com.example.demo.repository.BeansRepository;


@Service
public class BeansService {
	 @Autowired
	  private BeansRepository beansrepository;
	 
	
	  public List<BeansEntity> findAll() {
		  
		    return beansrepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		  }
	  
	  public void delete(Integer id){
		  beansrepository.deleteById(id);
		  }
	  

		public Optional<BeansEntity> selectById(Integer id) {
			return beansrepository.findById(id);
		}
		

		public void update(BeansEntity Beans) {
			BeansEntity Beansupdate = new BeansEntity();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Beansupdate.setId(Beans.getId());
			Beansupdate.setFarm(Beans.getFarm());
			Beansupdate.setName(Beans.getName());
			Beansupdate.setSmallsize(Beans.getSmallsize());
			Beansupdate.setMediumsize(Beans.getMediumsize());
			Beansupdate.setDrink(Beans.getDrink());
			
			beansrepository.save(Beansupdate);
		}
	  
	  
}
