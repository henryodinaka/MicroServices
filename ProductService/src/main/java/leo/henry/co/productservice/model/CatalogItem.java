package leo.henry.co.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItem {
    private String itemName;
    private String description;
    private int rating;
}
