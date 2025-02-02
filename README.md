



<body>
   <p>Bu orqali agar ikki fieldlar birgalikda unique bo'lsa ishlatilinadi</p>
<pre> <code>@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"corpName","address_street","address_homeNumber"}))</code>code></pre><br>

    <p>Bu orqali Biz Entityni ismini conflict berishi mumkin bo'lsa yoki o'zgartirishni xohlasak ishlatamiz</p>

    <pre>
<code>
 @Entity(name = "users")
</code>
</pre>
<p>Bu Yerda agar biror Entity ABstract class bo'lib undan qolgan classlar vorislik olsa Bu superclasslarni<b> @MappedSuperClass</b> deb elon qilishmiz zarur </p><br>

<pre>
<code>
package org.islom.dars111.entity.template;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass

public class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean active=true;
}
</code>
</pre>
 <p>Va shu abstrat classni ishlatish uchun BIz  <b>@EqualsAndHashCode(callSuper=true)</b> ni ishlatishimiz kerak shunda u superclassni chaqirib ishlatadi </p><br>
<pre>
    <code>
        package org.islom.dars111.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.islom.dars111.entity.template.AbsEntity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Category extends AbsEntity {
  @ManyToOne
    private Category parentCategory;
}
    </code>
</pre>
<h3>@NotNull annotatsiyasini ishlatishning yo'li</h3>
<pre>
  <code>
    import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CompanyDto {
    @NotNull(message = "corpId bo'sh bo'lmasligi kerak")
    private String corpName;

    @NotNull(message = "directorName bo'sh bo'lmasligi kerak")
    private String directorName;

    @NotNull(message = "street bo'sh bo'lmasligi kerak")
    private String street;

    @NotNull(message = "homeNumber bo'sh bo'lmasligi kerak")
    private String homeNumber;
}

  </code>
</pre>

<pre>
  <code>
      &lt;dependency&gt;
            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
            &lt;artifactId&gt;spring-boot-starter-validation&lt;/artifactId&gt;
        &lt;/dependency&gt;
  </code>
</pre>

<p>Biz <b>@Valid</b> so'zi bizga NotNullni ishlatayotganimizni BIldiradi va avtomat Value null bo'lsa qiymatning null degan error qaytaradi</p>

<pre>
  <code>
        /*
     * Mijozni tahrirlash
     * @param id
     * @param customerDto
     * @return ApiResponse
     * Bizga id va Customer tipida json Object beradu*/
    @PutMapping("/customers/{id}")
    public HttpEntity<ApiResponse> updateCustomer(@PathVariable int id, @Valid @RequestBody CustomerDto customerDto) {

        ApiResponse apiResponse = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.status(apiResponse.isSuccess()
                ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

 

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

  </code>
</pre>
<body>
<h2>Bu loyihada controller va servicelarsiz qanday qilib default methodlarni yaratish o'rgatiladi birinchi bo'lib repostoryni bunday o'zgartiramiz </h2>
<pre>
<code>
    <font size="2">
        ///path bu yerda link,collectionResourceREl esa qaytarib yuboradigan listning addresses o'rniga=>list deb qaytaradi
@RepositoryRestResource(path = "address",collectionResourceRel = "list",excerptProjection = CustomAddress.class)
public interface AddresRepo extends JpaRepository<Address, Integer> {
} 
    </font>
</code>
</pre>
<h2>default tarzda ReposityoryRestResourceda id qaytarilmaydi shuning uchun biz custom projection yozamiz</h2>
<pre>
<code>
    <pre style="background-color: #f4f4f4; border: 1px solid #ddd; padding: 10px;">
@Projection(types = Address.class)
public interface CustomAddress {
    Integer getId();
    String getStreet();
    String getCity();
}
        </pre>
</code>
</pre>
</body>
  
