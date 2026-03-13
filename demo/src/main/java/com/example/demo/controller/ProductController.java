package com.example.demo.controller;


import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/produto")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> cadastrarProduto(@RequestBody ProductModel productModel){
        return ResponseEntity.status(204).body(productModel);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ProductModel> atualizarProduto(@RequestBody ProductModel productModel){
        return ResponseEntity.status(204).body(productModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        productService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> buscarId(@PathVariable Long id){
        ProductModel produto = productService.buscarId(id);
        return ResponseEntity.ok(produto);
    }




}
