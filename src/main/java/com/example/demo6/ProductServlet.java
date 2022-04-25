package com.example.demo6;

import com.example.demo6.model.Product;
import com.example.demo6.request.ProductDeleteRequest;
import com.example.demo6.request.ProductRequestSave;
import com.example.demo6.request.ProductUpdateResponse;
import com.example.demo6.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Product", value = "/product")
public class ProductServlet extends HttpServlet {

    private final ProductService productService=new ProductService();
    private final  Gson gson = new Gson();
    private final ObjectMapper objectMapper=new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products=productService.findAll();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(products));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRequestSave productRequestSave = objectMapper.readValue(request.getInputStream(), ProductRequestSave.class);
        Product product=createProduct(productRequestSave);
        productService.save(product);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(product));
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductUpdateResponse productUpdateResponse = objectMapper.readValue(req.getInputStream(), ProductUpdateResponse.class);
        productService.update(productUpdateResponse);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.remove(Integer.parseInt(req.getParameter("id")));
    }

    private Product createProduct(ProductRequestSave productRequestSave) {
        return Product.builder()
                .price(productRequestSave.getPrice())
                .name(productRequestSave.getName())
                .count(productRequestSave.getCount())
                .build();
    }
}
