package com.spmabg.appsuivipregols.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spmabg.appsuivipregols.entity.Notification;



public interface NotificationRepository extends JpaRepository<Notification, Long> {
	

}