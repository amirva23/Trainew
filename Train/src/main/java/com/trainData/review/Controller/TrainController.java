package com.trainData.review.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainData.review.Model.Traindetails;
import com.trainData.review.Repository.Trainrepo;


@RestController
@RequestMapping("/mapping")
public class TrainController {
	@Autowired
	Trainrepo trepo;

	
	@PostMapping("/get")
	public String saveDetails(@RequestBody Traindetails t)
	{
		trepo.save(t);
		return "Data is saved";
	}
	
	@PutMapping("/update")
	public Traindetails editTrain(@RequestBody Traindetails ep)
	{
		return trepo.saveAndFlush(ep);
		
	}
	
	@PutMapping("/update/{train_num}")
	public Traindetails editTrain(@RequestBody Traindetails sg,@PathVariable int train_num)
	{
		Traindetails sara = trepo.findById(train_num).orElse(null);
		if(sara!= null)
		{
			sara.setCost(sg.getCost());
			sara.setDestination(sg.getDestination());
			sara.setName(sg.getName());
			sara.setTrain_num(sg.getTrain_num());
			sara.setTicket(sg.getTicket());
			sara.setSource(sg.getSource());
			
			return trepo.saveAndFlush(sara);
		}
		else {
			return null;
		}
	}
	
	
	//NativeQuery
	
	
	@GetMapping("/query")
	public List<Traindetails> getAll()
	{
		return trepo.get();
	}
	
	@GetMapping("/queryget/{train_num}")
	public List<Traindetails> getdetails(@PathVariable int train_num)
	{
		return trepo.getD(train_num);
	}
	
	@PutMapping("/queryupdate/{train_num}/{name}")
	public void updateDetails(@PathVariable int train_num,@PathVariable String name)
	{
		 trepo.update(train_num,name); 
	}
	
	@DeleteMapping("/deletequery/{train_num}/{name}")
	public String deleteDetails(@PathVariable int train_num,@PathVariable String name)
	{
		
		trepo.deleteById(train_num,name);
		return "Deleted Successfully";
	}
	@DeleteMapping("/delete/{train_num}")
	public String deleteD(@PathVariable int train_num)
	{
		
		trepo.delete(train_num);
		return "Deleted Successfully";
	}
	@DeleteMapping("/deleteT/{ticket_no}")
	public String deletetop(@PathVariable int ticket_no)
	{
		
		trepo.deleteB(ticket_no);
		return "Deleted Successfully";
	}

	
	//jpql
	
	@GetMapping("/jpql/{train_num}")
	public List<Traindetails> get(@PathVariable int train_num)
	{
		return trepo.getDetails(train_num);
	}
	@GetMapping("/jpql/like")
	public List<Traindetails> getByTrain()
	{
		return trepo.getH();
	}
	@GetMapping("/jqpl/between/{train_num}/{train_id}")
	public List<Traindetails> getN(@PathVariable int train_num,@PathVariable int train_id)
	{
		return trepo.getNow(train_num,train_id);
	}


}
