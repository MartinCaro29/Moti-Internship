package com.ikub.motidatabase.controller;

import com.ikub.motidatabase.entity.Moti;
import com.ikub.motidatabase.service.MotiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotiController {
    @Autowired
    private MotiService motiService;

    @PostMapping("/addMoti")
    public Moti postDetails(@RequestBody Moti moti){
        return motiService.saveDetails(moti);
    }

    @GetMapping("/getMoti")
    public List<Moti> getDetails(){
        return motiService.getAllDetails();
    }

    @PutMapping("/updateMoti")
    public Moti updateMotiDetails(@RequestBody Moti moti){
        return motiService.updateDetail(moti);
    }

    @DeleteMapping("/deleteMoti/{id}")
    public String deleteFunction(@PathVariable int id){
        return motiService.deleteMoti(id);
    }




}
