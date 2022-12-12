package com.example.wartatenieya.repository;

import com.example.wartatenieya.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel,Integer> {
    List<Personnel> findPersonnelsByDateRecrutementAfterAndDateRecrutementBefore(Date startDate,Date endDate);
//int countByPosteGARDEJOURAndZoneParking_Adresse(String adresse);


}
