package com.comprasapi.icligo.services;

import com.comprasapi.icligo.DAO.IProductType;
import com.comprasapi.icligo.errors.ProductTypeNotFound;
import com.comprasapi.icligo.models.Product_type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    private IProductType product_type_dao;

    public ProductTypeService(IProductType product_type_dao){
        this.product_type_dao = product_type_dao;
    }

    public List<Product_type> getAllTypes(){
        List<Product_type> list = product_type_dao.findAll();
        return list;
    }

    public Product_type getPType(Long id) throws ProductTypeNotFound {
        Product_type ptype = product_type_dao.findById(id).orElseThrow(() -> new ProductTypeNotFound(id));
        return ptype;
    }

    public Product_type newPType(Product_type ptype){
        Product_type newptype = product_type_dao.save(ptype);
        return newptype;
    }

    public Product_type updatePType(Product_type ptype) throws ProductTypeNotFound {
        Product_type oldpType = product_type_dao.findById(ptype.getId_product_type()).orElseThrow(() -> new ProductTypeNotFound(ptype.getId_product_type()));
        oldpType.setType_description(ptype.getType_description());

        product_type_dao.save(oldpType);
        return oldpType;
    }

    public Boolean deletePType(Long id) throws ProductTypeNotFound {
        Product_type ptypetodelete = product_type_dao.findById(id).orElseThrow(() -> new ProductTypeNotFound(id));
        product_type_dao.deleteById(id);
        return true;
    }
}
