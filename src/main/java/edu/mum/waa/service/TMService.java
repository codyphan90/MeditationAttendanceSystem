package edu.mum.waa.service;


import edu.mum.waa.entity.TM;

import java.util.List;

public interface TMService {

    public void saveTmCheck(TM tm);
    public List<TM> getAllTmsChecked();
    public TM getTmCheckById(int theId);
   public void  deleteTmCheck(int theId);
}
