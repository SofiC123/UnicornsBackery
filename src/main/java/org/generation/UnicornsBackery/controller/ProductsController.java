package org.generation.UnicornsBackery.controller;

import org.generation.UnicornsBackery.model.Products;
import org.generation.UnicornsBackery.repositories.ProductsRepository;
import org.generation.UnicornsBackery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@Controller // This means that this class is a Controller
@RequestMapping(path="/product") // This means URL's start with /demo (after Application path)

public class ProductsController {
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private ProductsRepository productsRepository;

    ProductsController(ProductsRepository productR){ productsRepository = productR;}

    ProductsController(){}


    @PostMapping(path="/addProduct") // Map ONLY POST Requests
    public @ResponseBody String addNewProduct (@RequestBody Products product) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        /*@RequestPart("route_image") String route_image,
                                               @RequestPart("description") String description,
                                               @RequestPart("name") String name,
                                               @RequestPart("quantity") int quantity,
                                               @RequestPart("price") float price,
                                               @RequestPart("tags") String tags,
                                               @RequestPart("id_category") int id_category */

        Products newProduct = new Products();
        newProduct.setRoute_image(product.getRoute_image());
        newProduct.setDescription(product.getDescription());
        newProduct.setName(product.getName());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setPrice(product.getPrice());
        newProduct.setTags(product.getTags());
        newProduct.setId_category(product.getId_category());
        productsRepository.save(newProduct);
        return "Saved";
    }

    @PostMapping(path="/checkProduct")
    public @ResponseBody Boolean checkProduct(@RequestParam String name,
                                           @RequestParam String tags){
        Iterable<Products> products = productsRepository.findAll();
        for (Products product: products) {
            if(product.getName().equals(name) && product.getTags().equals(tags)){
                return true;
            }
        }
        return false;
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Products> getAllProducts() {
        // This returns a JSON or XML with the users
        return productsRepository.findAll();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody Iterable<Products> findProduct(@PathVariable int id){
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        return productsRepository.findAllById(ids);
    }


    @DeleteMapping(path = "delete/{id}")
    public @ResponseBody void deleteProduct(@PathVariable int id){
        productsRepository.deleteById(id);
    }

    @PutMapping(path = "update/{id}")
    public @ResponseBody void updateProduct(@PathVariable int id,
                                            @RequestParam String route_image,
                                            @RequestParam String description,
                                            @RequestParam String name,
                                            @RequestParam int quantity,
                                            @RequestParam float price,
                                            @RequestParam String tags,
                                            @RequestParam int id_category,
                                            @RequestParam String createAt,
                                            @RequestParam String updateAt) {
        Products updateProduct = new Products();
        updateProduct.setIdProducts(id);
        updateProduct.setRoute_image(route_image);
        updateProduct.setDescription(description);
        updateProduct.setName(name);
        updateProduct.setQuantity(quantity);
        updateProduct.setPrice(price);
        updateProduct.setTags(tags);
        updateProduct.setId_category(id_category);
        updateProduct.setCreateAt(createAt);
        updateProduct.setUpdateAt(updateAt);
        productsRepository.save(updateProduct);
    }
}
