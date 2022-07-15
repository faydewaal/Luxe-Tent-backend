package nl.novi.luxetent.services;

import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dto.ReviewDto;
import nl.novi.luxetent.models.Review;
import nl.novi.luxetent.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewDto> getAllReviews() {
        List<Review> review = reviewRepository.findAll();
        List<ReviewDto> dtos = new ArrayList<>();
        for (Review r : review) {
            dtos.add(transferToDto(r));
        }
        return dtos;
    }

    public ReviewDto getReview(long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if(review.isPresent()) {
            ReviewDto r = transferToDto(review.get());
            return r;
        } else {
            throw new RecordNotFoundException("geen review voor deze tent");
        }
    }

    public ReviewDto addReview(ReviewDto ReviewDto) {
        reviewRepository.save(transferToReview(ReviewDto));
        return ReviewDto;
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public void updateReview(Long id, ReviewDto reviewDto) {
        if(!reviewRepository.existsById(id)) {
            throw new RecordNotFoundException("geen review gevonden voor deze tent");
        }
        Review storedReview = reviewRepository.findById(id).orElse(null);
        storedReview.setId(reviewDto.getId());
        storedReview.setComment(reviewDto.getComment());
        reviewRepository.save(storedReview);
    }

    public Review transferToReview(ReviewDto dto){
        Review review = new Review();

        review.setId(dto.getId());
        review.setComment(dto.getComment());

        return review;
    }

    public static ReviewDto transferToDto(Review review){
        var dto = new ReviewDto();

        dto.setId(review.getId());
        dto.setComment(review.getComment());

        return dto;
    }
}
