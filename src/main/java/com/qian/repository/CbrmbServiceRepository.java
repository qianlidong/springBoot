package com.qian.repository;


import com.qian.domain.CbCorpApply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public abstract interface CbrmbServiceRepository
  extends JpaRepository<CbCorpApply, String>
{

  public abstract CbCorpApply findByCustId(String custId);


}
