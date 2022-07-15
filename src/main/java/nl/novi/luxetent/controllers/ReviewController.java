package nl.novi.luxetent.controllers;

import nl.novi.luxetent.dto.ReviewDto;
import nl.novi.luxetent.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<ReviewDto> getAllReviews() {

        List<ReviewDto> dtos = reviewService.getAllReviews();

        return dtos;
    }

    @GetMapping("/review/{id}")
    public ReviewDto getReview(@PathVariable("id") Long id) {

        ReviewDto reviewDto = reviewService.getReview(id);

        return reviewDto;
    }

    @PostMapping("/reviews")
    public ReviewDto addReview(@RequestBody ReviewDto dto) {
        ReviewDto reviewDto = reviewService.addReview(dto);
        return reviewDto;
    }

    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    }

    @PutMapping("/review/{id}")
    public ReviewDto updateReview(@PathVariable("id") Long id, @RequestBody ReviewDto reviewDto) {
        reviewService.updateReview(id, reviewDto);
        return reviewDto;
    }
}
