package com.kt.backend.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kt.backend.dto.ReviewDto;
import com.kt.backend.entity.Account;
import com.kt.backend.entity.Item;
import com.kt.backend.entity.Product;
import com.kt.backend.entity.Review;
import com.kt.backend.exception.ResourceNotFoundException;
import com.kt.backend.repository.AccountRepository;
import com.kt.backend.repository.ItemRepository;
import com.kt.backend.repository.ProductRepository;
import com.kt.backend.repository.ReviewRepository;
import com.kt.backend.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ReviewDto createReview(ReviewDto reviewDto, Integer accountId, Integer itemId) {
		
		Account account = this.accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account ", "accountId", accountId));
		
		Item item = this.itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item ", "itemId", itemId));
		
		if(item.getIsReviewed() == false) {
			Integer productId = item.getProduct().getId();
			Product product = this.productRepository.findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException("Product ", "productId", productId));

			Review review = this.modelMapper.map(reviewDto, Review.class);

			review.setAccount(account);
			review.setProduct(product);
			Review newReview = this.reviewRepository.save(review);
			item.setIsReviewed(true);
			this.itemRepository.save(item);
			return this.modelMapper.map(newReview, ReviewDto.class);
		}else {
			Review review = new Review();
			return this.modelMapper.map(review, ReviewDto.class);
		}
		
	}

	@Override
	public ReviewDto updateReview(ReviewDto reviewDto, Integer reviewId) {
		Review review = this.reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review ", "reviewId", reviewId));
		review.setContent(reviewDto.getContent());
		review.setDatereview(reviewDto.getDatereview());
		review.setNumberofstar(reviewDto.getNumberofstar());
		Review updateReview = this.reviewRepository.save(review);
		return this.modelMapper.map(updateReview, ReviewDto.class);
	}

	@Override
	public void deleteReview(Integer reviewId) {
		Review review = this.reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review", "ReviewId", reviewId));
		this.reviewRepository.delete(review);
		
	}

	@Override
	public List<ReviewDto> getReviewsOfAccount(Integer accountId) {
		List<Review> reviews = this.reviewRepository.findAllReviewOfAccount(accountId);
		List<ReviewDto> reviewDtos = reviews.stream().map((review) -> this.modelMapper.map(review, ReviewDto.class))
				.collect(Collectors.toList());
		return reviewDtos;
	}

	@Override
	public List<ReviewDto> getReviewsOfProduct(Integer productId) {
		List<Review> reviews = this.reviewRepository.findAllReviewOfProduct(productId);
		List<ReviewDto> reviewDtos = reviews.stream().map((review) -> this.modelMapper.map(review, ReviewDto.class))
				.collect(Collectors.toList());
		return reviewDtos;
	}

	@Override
	public Integer getTotalReview() {
		List<Review> reviews = this.reviewRepository.findAllReview();
		if(reviews == null) {
			return 0;
		}else {
			return reviews.size();
		}
	}

	@Override
	public List<ReviewDto> getAllReview() {
		List<Review> reviews = this.reviewRepository.findAllReview();
		List<ReviewDto> reviewDtos = reviews.stream().map((review) -> this.modelMapper.map(review, ReviewDto.class))
				.collect(Collectors.toList());
		return reviewDtos;
	}

}
