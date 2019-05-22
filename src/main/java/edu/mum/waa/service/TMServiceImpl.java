package edu.mum.waa.service;

import edu.mum.waa.entity.TM;
import edu.mum.waa.repository.TMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class TMServiceImpl implements TMService {

    @Autowired
    TMRepository tmRepository;

    @Override
    public List<TM> getAllTmsChecked(){
        return tmRepository.findAll();
    }
    @Override
    public void saveTmCheck(TM tm){

        tmRepository.save(tm);

    }

    public TM getTmCheckById(int theId){

        return tmRepository.getOne((long)theId);
    }

    //delete the tm check record
    public void deleteTmCheck(int theId){
        tmRepository.deleteById((long)theId);
    }

    public List<TM> checkDuplicate(LocalDate checkedDate){
        return tmRepository.checkDuplicate(checkedDate);

    }

    public List<TM>findAllTmChecksOfStudent(long id){
        return  tmRepository.findAllTmChecksOfStudent(id);
    }
}
