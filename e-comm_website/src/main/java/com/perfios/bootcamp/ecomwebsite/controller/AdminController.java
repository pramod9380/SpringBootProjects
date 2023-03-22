package com.perfios.bootcamp.ecomwebsite.controller;

import com.perfios.bootcamp.ecomwebsite.beans.Category;
import com.perfios.bootcamp.ecomwebsite.beans.Product;
import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.dto.ProductDTO;
import com.perfios.bootcamp.ecomwebsite.dto.UserDTO;
import com.perfios.bootcamp.ecomwebsite.exception.CategoryNotFoundException;
import com.perfios.bootcamp.ecomwebsite.exception.ProductNotFoundException;
import com.perfios.bootcamp.ecomwebsite.exception.UserNotFoundException;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.CategoryImpl;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.ProductImpl;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will provide all the admin functionalities
 */

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    @Autowired
    CategoryImpl categoryImpl;

    /**
     * Category section
     * admin can perform all crud operations on category
     */

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String adminCategory(Model model){
        List<Category> categories = categoryImpl.getAllCategories();
        model.addAttribute("categories",categories);
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String adminGetCategoryAddPage(Model model){
        Map<String , Object> map = new HashMap<>();
        map.put("category",new Category());
        model.addAllAttributes(map);
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String adminPostCategoryAddPage(@ModelAttribute("category") Category category){
        categoryImpl.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String adminDeleteCategory(@PathVariable("id") int id) throws CategoryNotFoundException {
        categoryImpl.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String adminUpdateCategory(@PathVariable("id") int id, Model model) throws CategoryNotFoundException {
        Category  category = categoryImpl.updateCategoryById(id);
        if(category!=null){
            model.addAttribute("category",category);
            return "categoriesAdd";
        }
        else
            return "Category with that id not found";
    }


    /**
     * Product Section
     * Admin can perform all crud operations on products
     */

    @Autowired
    ProductImpl productImpl;

    @GetMapping("/admin/products")
    public String adminProducts(Model model){
        model.addAttribute("products",productImpl.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String adminGetProductsAddPage(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryImpl.getAllCategories());
        return "productsAdd";
    }


    @PostMapping("/admin/products/add")
    public String adminPostProductAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
                                  @RequestParam("productImage") MultipartFile file,
                                  @RequestParam("imgName") String imageName) throws IOException, CategoryNotFoundException {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        product.setCategory(categoryImpl.getCategoryById(productDTO.getCategoryId()));

        String imageUUId;

        if(!(file.isEmpty())){
            imageUUId = file.getOriginalFilename();
            Path path = Paths.get(uploadDir,imageUUId);
            Files.write(path,file.getBytes());
        }else {
            imageUUId = imageName;
        }
        product.setImage(imageUUId);
        System.out.println("imageName: "+imageUUId);
        productImpl.saveProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String adminDeleteProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        productImpl.deleteProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String adminUpdateProduct(Model model, @PathVariable("id") int id) throws ProductNotFoundException {
        Product product = productImpl.updateProductById(id);
        ProductDTO productDTO = new ProductDTO();
        if(product!=null){
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setDiscount(product.getDiscount());
            productDTO.setDescription(product.getDescription());
            productDTO.setImage(product.getImage());
            productDTO.setCategoryId(product.getCategory().getId());

            model.addAttribute("categories", categoryImpl.getAllCategories());
            model.addAttribute("productDTO",productDTO);
            return "productsAdd";
        }
        return "404 error!";
    }

    /**
     *  Customer Section
     *  Admin can perform all crud operations on customers
     */

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/admin/users")
    public String adminUsers(Model model){
        userService.getAllUsers().stream().forEach(System.out::println);
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/admin/users/add")
    public String adminUsersGet(Model model){
        model.addAttribute("user",new User());
        return "userAdd";
    }

    @PostMapping("/admin/users/add")
    public String adminUserAdd(@ModelAttribute("user") UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmailId(userDTO.getEmailId());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setActive(userDTO.isActive());
        user.setRoles(userDTO.getRole());
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String adminDeleteUser(@PathVariable("id") int id) throws UserNotFoundException {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/user/update/{id}")
    public String adminUpdateUser(Model model, @PathVariable("id") int id) throws UserNotFoundException {
        User user = userService.updateUserDetails(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userAdd";
        }
        return "Error 404!!";
    }
}
