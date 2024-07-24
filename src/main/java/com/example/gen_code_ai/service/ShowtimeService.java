package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.ShowtimeRequest;
import com.example.gen_code_ai.dto.ShowtimeResponse;
import com.example.gen_code_ai.entity.Showtime;
import com.example.gen_code_ai.exception.ShowtimeNotFoundException;
import com.example.gen_code_ai.repository.MovieRepository;
import com.example.gen_code_ai.repository.ShowtimeRepository;
import com.example.gen_code_ai.repository.TheaterRepository;
import com.example.gen_code_ai.utils.DateTimeUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

  @Autowired private ShowtimeRepository showtimeRepository;

  @Autowired private MovieRepository movieRepository;

  @Autowired private TheaterRepository theaterRepository;

  public List<ShowtimeResponse> getAllShowtime() {
    return showtimeRepository.findAll().stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
  }

  public ShowtimeResponse createShowtime(ShowtimeRequest request) {
    Showtime showtime = convertToEntity(request);
    Showtime savedShowtime = showtimeRepository.save(showtime);
    return convertToResponse(savedShowtime);
  }

  public ShowtimeResponse updateShowtime(ShowtimeRequest request) {
    Showtime showtime =
        showtimeRepository
            .findById(request.getShowtimeId())
            .orElseThrow(
                () ->
                    new ShowtimeNotFoundException(
                        "Showtime not found with id: " + request.getShowtimeId()));
    updateShowtimeFromRequest(showtime, request);
    Showtime updatedShowtime = showtimeRepository.save(showtime);
    return convertToResponse(updatedShowtime);
  }

  public ShowtimeResponse getShowtimeById(Long id) {
    Showtime showtime =
        showtimeRepository
            .findById(id)
            .orElseThrow(() -> new ShowtimeNotFoundException("Showtime not found with id: " + id));
    return convertToResponse(showtime);
  }

  public void deleteShowtime(Long id) {
    if (!showtimeRepository.existsById(id)) {
      throw new ShowtimeNotFoundException("Showtime not found with id: " + id);
    }
    showtimeRepository.deleteById(id);
  }

  private Showtime convertToEntity(ShowtimeRequest request) {
    Showtime showtime = new Showtime();
    updateShowtimeFromRequest(showtime, request);
    return showtime;
  }

  private void updateShowtimeFromRequest(Showtime showtime, ShowtimeRequest request) {
    // MovieEntity movie = movieRepository.findById(request.getMovieId()).orElseThrow(() -> new
    // MovieNotFoundException("Movie not found with id: " + request.getMovieId()));
    // Theater theater = theaterRepository.findById(request.getTheaterId()).orElseThrow(() -> new
    // TheaterNotFoundException("Theater not found with id: " + request.getTheaterId()));

    // showtime.setMovie(movie);
    // showtime.setTheater(theater);
    showtime.setStartTime(DateTimeUtil.convertToLocalDateTime(request.getStartTime()));
    showtime.setEndTime(DateTimeUtil.convertToLocalDateTime(request.getEndTime()));
    showtime.setPrice(request.getPrice());
  }

  // convert showtime entity to showtime response
  private ShowtimeResponse convertToResponse(Showtime showtime) {
    ShowtimeResponse response = new ShowtimeResponse();
    response.setShowtimeId(showtime.getShowtimeId());
    response.setMovieId(showtime.getMovie().getId());
    // response.setTheaterId(showtime.getTheater().getId());
    response.setStartTime(DateTimeUtil.convertToOffsetDateTime(showtime.getStartTime()));
    response.setEndTime(DateTimeUtil.convertToOffsetDateTime(showtime.getEndTime()));
    response.setPrice(showtime.getPrice());
    return response;
  }
}
