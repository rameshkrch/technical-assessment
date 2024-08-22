package com.example.warehouseservice.warehouse.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> saveProducts(List<ProductDto> productDtoList) {
        var productDaoList = productDtoListToDaoList(productDtoList);
        productRepository.saveAll(productDaoList);
        return productDaoListToDtoList(productDaoList);
    }

    public List<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    public List<SalesProduct> getAvailableProducts() {
        var products = productRepository.findAll();

        return products.stream()
                .map(this::findAvailableQuantity)
                .filter(salesProduct -> salesProduct.quantity() > 0)
                .collect(Collectors.toList());
    }

    private SalesProduct findAvailableQuantity(ProductDao productDao) {
        var quantity = productDao.getParts().stream()
                .map(this::findAvailablePartQuantity)
                .min(Comparator.comparing(Integer::valueOf))
                .get();

        return new SalesProduct(productDao.getName(), quantity);
    }

    private int findAvailablePartQuantity(ProductPartDao productPartDao) {
        var quantity = productPartDao.getQuantity();
        var stock = productPartDao.getArticle().getQuantity();
        return stock / quantity;
    }

    public List<ProductDto> sellProduct(String s, Integer quantity) {
        // TODO: Verify inventory

        // TODO: Update inventory
        return null;
    }


    //////////// Helpers (maybe move to another file)


    private List<ProductDao> productDtoListToDaoList(List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(this::productDtoToDao)
                .collect(Collectors.toList());
    }

    private ProductDao productDtoToDao(ProductDto productDto) {
        var productDao = new ProductDao(
                productDto.name(),
                productDto.price());
        productDao.setParts(productPartDtoListToDaoList(productDto.parts(),productDao));
        return productDao;
    }

    private List<ProductPartDao> productPartDtoListToDaoList(List<ProductPartDto> productPartDtoList, ProductDao productDao) {
        return productPartDtoList.stream()
                .map(productPartDto -> productPartDtoToDao(productPartDto, productDao))
                .collect(Collectors.toList());
    }

    private ProductPartDao productPartDtoToDao(ProductPartDto productPartDto, ProductDao productDao) {
        return new ProductPartDao(
                productDao,
                new Article(productPartDto.artId()),
                productPartDto.quantity());
    }

    private List<ProductDto> productDaoListToDtoList(List<ProductDao> productDaoList) {
        return productDaoList.stream()
                .map(this::productDaoToDto)
                .collect(Collectors.toList());
    }

    private ProductDto productDaoToDto(ProductDao productDao) {
        return new ProductDto(
                productDao.getName(),
                productDao.getPrice(),
                productPartDaoListToDtoList(productDao.getParts()));
    }

    private List<ProductPartDto> productPartDaoListToDtoList(List<ProductPartDao> parts) {
        return parts.stream()
                .map(this::productPartDaoToDto)
                .collect(Collectors.toList());
    }

    private ProductPartDto productPartDaoToDto(ProductPartDao productPartDao) {
        return new ProductPartDto(
            productPartDao.getArticle().getId(),
            productPartDao.getQuantity());
    }

}
