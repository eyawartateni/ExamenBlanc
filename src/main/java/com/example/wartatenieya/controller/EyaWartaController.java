package com.example.wartatenieya.controller;

import com.example.wartatenieya.entities.Parking;
import com.example.wartatenieya.entities.Personnel;
import com.example.wartatenieya.entities.Zone;
import com.example.wartatenieya.repository.ParkingRepository;
import com.example.wartatenieya.repository.PersonnelRepository;
import com.example.wartatenieya.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class EyaWartaController {
   @Autowired
    PersonnelRepository personnelRepository;
      @Autowired
    ParkingRepository parkingRepository;
     @Autowired
    ZoneRepository zoneRepository;

    @PostMapping("/ajouterPersonnel")
            Personnel ajouterPersonnel(@RequestBody Personnel personnel)
    {
       return personnelRepository.save(personnel);
    }

    @PostMapping("/ajouterParkingZones")
    void ajouterParkingZones(@RequestBody Parking parking)
    {

       parkingRepository.save(parking);

    }
@Transactional
    @PostMapping("/affecterPersonnelZone/{idzone}/{idGarde}")
    void ajouterParkingZones(@PathVariable int idzone,@PathVariable int idGarde)
    {

        Zone zone=zoneRepository.findById(idzone).orElse(null);
        Personnel garde =personnelRepository.findById(idGarde).orElse(null);
        zone.getGardes().add(garde);
        garde.setZone(zone);
        zoneRepository.save(zone);
        personnelRepository.save(garde);



    }




    @GetMapping("/getAllPersoByParking")
        List<Personnel> getAllPersoByParking(@RequestBody Parking parking)
        {
            Parking parking1=parkingRepository.findById(parking.getId()).orElse(null);

            return personnelRepository.findAll()
                    .stream()
                    .filter(personnel -> personnel.getZone().getParking().getId()==parking1.getId())
                    .collect(Collectors.toList());




        }

    @GetMapping("/getPersonnelByDate/{startDate}/{endDate}")
    public List<Personnel> getPersonnelByDate (
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate

    )
    {
        return  personnelRepository.findPersonnelsByDateRecrutementAfterAndDateRecrutementBefore(startDate,endDate);
    }

    @Scheduled(fixedRate = 30000)
    public void getNbrGardesByZone()
    {

    }

    @GetMapping("/getNbreGardeJour/{adresse}")
    int nombreGardeJour(@PathVariable String adresse)
    {

      return personnelRepository.findAll().stream()
              .filter(personnel -> personnel.getZone().getParking().getAdresse().equals(adresse) && personnel.getPoste().toString().equals("GARDEJOUR"))
              .collect(Collectors.toList())
              .size();
    }
}
