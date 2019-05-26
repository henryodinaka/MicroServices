package leo.henry.co.ratingcomment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating  {
    private Long itemId;
    private int rating;
}
