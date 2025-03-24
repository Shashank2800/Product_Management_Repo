package com.ina;

import com.ina.entity.Product;
import com.ina.service.ProductService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ProductManagementApplicationTests {

//    @Autowired
//    private MyController myController;

    @Mock
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private ObjectMapper objectMapper;



//    @Test
//    public void givenListOfProducts_whenGetAllProducts_thenReturnProductList() throws Exception {
//
//        //Giving list of products
//        Product product1 = Product.builder().
//                productName("Cycle").productDescription("Gear").productPrice(15000.00).location("Delhi").build();
//        Product product2 = Product.builder().
//                productName("Scooty").productDescription("Activa").productPrice(98000.00).location("Mumbai").build();
//        List<Product> productList = List.of(product1, product2);
//        assertThat(productService.findAll()).matches(x -> x.equals(productList));
//        assertThat(productService.findAll()).matches(productList::containsAll);
//
//        // when -  action or the behaviour that we are going test
//        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/products/getAll"));
//
//
//        // then - verify the output
//        response.andExpect(status().isOk())
//                .andDo(print()).
//                andExpect(MockMvcResultMatchers.jsonPath("$.size()", is(productList.size())));
//
//    }

    //@Test
    public void testGetProductByName() throws Exception {
        // Given: Prepare the mock response
        Product mockproduct = Product.builder().
                productName("Cycle").productDescription("Gear").productPrice(15000.00).location("Delhi").build();

        Mockito.when(productService.findByName("Cycle")).thenReturn(Optional.ofNullable(mockproduct));


        // When: Perform GET request
        mockMvc.perform(post("/product/getByName/{productName}", "Cycle"))
                .andExpect(status().isOk())  // Expect status 200
                .andExpect((ResultMatcher) jsonPath("$.productName").value("Cycle"))
                .andExpect((ResultMatcher) jsonPath("$.productDescription").value("Gear"));
    }


//    @Test
//    public void getByProduct_id()
//    {
//        List<Product> productList = myController.getByProduct_id(1);
//        System.out.println(productList);
//        assertThat(productList).isNotNull();
//        assertThat(productList.size()).isGreaterThan(0);
//    }
//
//    @Test
//    public void addProduct()
//    {
//        Product product = new Product();
//        product.setProductName("Truck");
//        product.setProductDescription("Goods Carrier");
//        product.setProductPrice(500000.00);
//        product.setLocation("Hyderabad");
//        myController.addProduct(product);
//        Integer productId=myController.getByProductName("Truck").get(0).getProductId();
//        System.out.println(productId);
//        assertNotNull(myController.getByProduct_id(productId));
//        assertNotNull(myController.getByProductName("Truck"));
//    }
//
//    @Test
//    public void updateProduct()
//    {
//        Product product = new Product();
//        product.setProductId(1);
//        product.setProductName("Auto");
//        product.setProductDescription("Goods Carrier");
//        product.setProductPrice(50000.00);
//        product.setLocation("Chennai");
//        myController.updateProduct(product);
//        assertNotNull(myController.getByProduct_id(1));
//        assertNotNull(myController.getByProductName("Auto"));
//        System.out.println(myController.getByProduct_id(1));
//    }
//
//
//    @Test
//    public void deleteProduct()
//    {
//        Product product = new Product();
//        product.setProductId(4);
//        product.setProductName("Auto");
//        product.setProductDescription("Goods Carrier");
//        product.setProductPrice(50000.00);
//        product.setLocation("Chennai");
//
//        myController.deleteProduct(product);
//        assertThat(myController.getByProduct_id(4)).isNull();
//
//    }

}

/*
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;  // Mocking the service layer

    @Test
    public void testCreatePerson() throws Exception {
        // Given: Prepare the mock response
        Person mockPerson = new Person("John", 30);
        Mockito.when(personService.savePerson(Mockito.any(Person.class))).thenReturn(mockPerson);

        // When: Perform POST request
        String requestBody = "{ \"name\": \"John\", \"age\": 30 }";
        mockMvc.perform(post("/api/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated())  // Expect status 201
                .andExpect(jsonPath("$.name").value("John"))  // Check name in response
                .andExpect(jsonPath("$.age").value(30));  // Check age in response
    }

    @Test
    public void testGetPerson() throws Exception {
        // Given: Prepare the mock response
        Person mockPerson = new Person("Jane", 25);
        Mockito.when(personService.getPersonById(1L)).thenReturn(mockPerson);

        // When: Perform GET request
        mockMvc.perform(get("/api/people/{id}", 1L))
                .andExpect(status().isOk())  // Expect status 200
                .andExpect(jsonPath("$.name").value("Jane"))  // Check name in response
                .andExpect(jsonPath("$.age").value(25));  // Check age in response
    }

    @Test
    public void testGetPersonNotFound() throws Exception {
        // Given: Mock service to return null
        Mockito.when(personService.getPersonById(1L)).thenReturn(null);

        // When: Perform GET request
        mockMvc.perform(get("/api/people/{id}", 1L))
                .andExpect(status().isNotFound());  // Expect status 404 (not found)
    }
}

 */
