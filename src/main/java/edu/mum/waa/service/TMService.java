package edu.mum.waa.service;



import edu.mum.waa.entity.TM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TMService {

    public void saveTmCheck(TM tm);
    public List<TM> getAllTmsChecked();
    public TM getTmCheckById(int theId);
    public void  deleteTmCheck(int theId);
    public List<TM> checkDuplicate(LocalDate checkedDate);
    List<TM>findAllTmChecksOfStudent(long id);
}
