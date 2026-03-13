package com.example.demo.service;

import com.example.demo.model.ProductModel;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<ProductModel> findAll(){
        return productRepository.findAll();
    }


    public void deletarProduto(Long id){
        productRepository.deleteById(id);
    }

    public ProductModel buscarId(Long id){
        return productRepository.findById(id);
    }


    public ProductModel cadastrarProduto(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public ProductModel atualizarProduto(Long id, ProductModel productModel){
        ProductModel produto = productRepository.findById(id).get();

        produto.setNome(productModel.getNome());
        produto.setPreco(productModel.getPreco());

        return productRepository.save(produto);
    }
}
