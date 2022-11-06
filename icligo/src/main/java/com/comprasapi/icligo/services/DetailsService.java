package com.comprasapi.icligo.services;

import com.comprasapi.icligo.DAO.IDetails;
import com.comprasapi.icligo.errors.DetailNotFound;
import com.comprasapi.icligo.errors.PurchaseNotFound;
import com.comprasapi.icligo.models.Details;
import com.comprasapi.icligo.models.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsService {

    private IDetails detailsdao;

    // em vez de autowired, fazemos construtor para autoinjeçao de dependencias
    public DetailsService(IDetails detailsdao){
        this.detailsdao = detailsdao;
    }

    public List<Details> getAllDetails(){
        List<Details> list = detailsdao.findAll();
        return list;
    }

    public Details getDetail(Long id) throws DetailNotFound {
        Details detail = detailsdao.findById(id).orElseThrow(() -> new DetailNotFound(id));
        return detail;
    }

    public Details newDetail(Details details){
        Details newDetails = detailsdao.save(details);
        return newDetails;
    }

    public Details updateDetail(Details details) throws PurchaseNotFound {
        Details oldDetails = detailsdao.findById(details.getId_detail()).orElseThrow(() -> new PurchaseNotFound(details.getId_detail()));
        oldDetails.setDescription(details.getDescription());
        oldDetails.setQuantity(details.getQuantity());
        oldDetails.setValue(details.getValue());

        detailsdao.save(oldDetails);
        return oldDetails;
    }

    public Boolean deleteDetail(Long id) throws DetailNotFound {
        Details detailstodelete = detailsdao.findById(id).orElseThrow(() -> new DetailNotFound(id));
        detailsdao.deleteById(id);
        return true;
    }
}
