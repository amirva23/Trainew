package com.trainData.review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainData.review.Model.Ticketdetails;

public interface Ticketrepo extends JpaRepository<Ticketdetails, Integer> {

}
