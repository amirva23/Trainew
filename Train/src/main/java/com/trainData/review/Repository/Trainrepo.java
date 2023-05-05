package com.trainData.review.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trainData.review.Model.Traindetails;

import jakarta.transaction.Transactional;


public interface Trainrepo extends JpaRepository<Traindetails, Integer> {
	
	//native
	
	@Query(value="select * from traindetails ",nativeQuery=true)
	public List<Traindetails> get();
	
	@Query(value="select * from traindetails where train_num = ?1", nativeQuery = true)
	public List<Traindetails> getD(@Param("train_num") int train_num);
	
	@Modifying
	@Transactional
	@Query(value="update traindetails set train_num =:train_num where name =:name",nativeQuery=true)
	public void  update(@Param("train_num") int train_num,@Param("name") String name);
	

	@Modifying
	@Transactional
	@Query(value="delete from traindetails where train_num=:train_num and name =:name",nativeQuery=true)
	Integer deleteById(@Param("train_num") int train_num,@Param("name") String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from traindetails where train_num=:train_num ",nativeQuery=true)
	Integer delete(@Param("train_num") int train_num);
	
	@Modifying
	@Transactional
	@Query(value="delete from source where details_train_num=:ticket_no ",nativeQuery=true)
	Integer deleteB(@Param("ticket_no") int ticket_no);



	//jpql
	
	@Query(value="select c from Traindetails c where train_num =?1",nativeQuery = false)
	public List<Traindetails> getDetails(@Param("train_num") int train_num);
	
	@Query(value="select t from Traindetails t where  source like '%i'",nativeQuery = false)
	public List<Traindetails> getH();
	
	@Query(value="select t from Traindetails t where train_num  between ?1 and ?2",nativeQuery=false)
	public List<Traindetails> getNow(@Param("train_num") int train_num,@Param("train_num") int trainid);

}
