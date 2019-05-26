package leo.henry.co.ratingcomment.apiReturns;

import leo.henry.co.ratingcomment.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {

    private List<Rating> ratings;
}
