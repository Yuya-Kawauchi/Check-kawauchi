package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BeansEntity;
@Repository
public interface BeansRepository  extends JpaRepository <BeansEntity,Integer>{

}
