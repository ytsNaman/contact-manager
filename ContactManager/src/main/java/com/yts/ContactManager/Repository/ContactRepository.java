package com.yts.ContactManager.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yts.ContactManager.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	List <Contact> findByNameContainingIgnoreCaseOrPhoneContaining(String name , String phone);
	boolean existsByPhone(String phone);
}
