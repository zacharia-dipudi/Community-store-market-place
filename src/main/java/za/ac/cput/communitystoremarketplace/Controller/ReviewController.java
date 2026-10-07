package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Review;
import za.ac.cput.communitystoremarketplace.Service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public Review create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @GetMapping("/read")
    public Review read(@RequestParam Long reviewId) {
        return reviewService.read(reviewId);
    }

    @PutMapping("/update")
    public Review update(@RequestBody Review review) {
        return reviewService.update(review);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long reviewId) {
        return reviewService.delete(reviewId);
    }

    @GetMapping("/getAll")
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/getByProduct")
    public List<Review> getByProduct(@RequestParam Long productId) {
        return reviewService.getByProductId(productId);
    }

    @GetMapping("/getByReviewer")
    public List<Review> getByReviewer(@RequestParam Long reviewerId) {
        return reviewService.getByReviewerId(reviewerId);
    }
}
