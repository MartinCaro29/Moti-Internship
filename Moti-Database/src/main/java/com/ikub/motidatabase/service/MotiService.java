package com.ikub.motidatabase.service;

import com.ikub.motidatabase.entity.Moti;
import com.ikub.motidatabase.repository.MotiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotiService {

    @Autowired
    private MotiRepository motiRepository;

    public Moti saveDetails(Moti moti){
        return motiRepository.save(moti);
    }

    public List<Moti> getAllDetails(){
        return motiRepository.findAll();
    }

    public Moti updateDetail(Moti moti){
        Moti updateMoti = motiRepository.findById(moti.getMatje_id()).orElse(null);
        if(updateMoti!=null){
            updateMoti.setQyteti(moti.getQyteti());
            updateMoti.setDita(moti.getDita());
            updateMoti.setTemperatura(moti.getTemperatura());
            updateMoti.setLageshtia(moti.getLageshtia());
            motiRepository.save(updateMoti);
            return updateMoti;

        }
        return null;
    }

    public String deleteMoti(int id) {
        if (motiRepository.existsById(id)) {
            motiRepository.deleteById(id);
            return "deleted " + id;
        }else return "id is invalid";

    }

}
