package leo.henry.co.ratingcomment.controller;

import leo.henry.co.ratingcomment.apiReturns.UserRating;
import leo.henry.co.ratingcomment.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @GetMapping("/{itemId}")
    public Rating getRating(@PathVariable("itemId")Long itemId){
        return new Rating(itemId,4);
    }
    @GetMapping("/user/{userId}")
    public UserRating getRatingByUser(@PathVariable("userId")Long userId){
        UserRating userRating = new UserRating();
        userRating.setRatings(Arrays.asList(
                new Rating(1L,4),
                new Rating(2L,3),
                new Rating(3L,5)));
        return  userRating;
    }
}
