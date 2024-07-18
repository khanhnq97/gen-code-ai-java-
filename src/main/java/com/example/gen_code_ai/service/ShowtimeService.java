package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.ShowtimeRequest;
import com.example.gen_code_ai.dto.ShowtimeResponse;
import com.example.gen_code_ai.entity.MovieEntity;
import com.example.gen_code_ai.entity.ShowtimeEntity;
import com.example.gen_code_ai.entity.TheatersEntity;
import com.example.gen_code_ai.exception.MovieNotFoundException;
import com.example.gen_code_ai.exception.ShowtimeNotFoundException;
import com.example.gen_code_ai.exception.TheaterNotFoundException;
import com.example.gen_code_ai.repository.MovieRepository;
import com.example.gen_code_ai.repository.ShowtimeRepository;
import com.example.gen_code_ai.repository.TheatersRepository;
import com.example.gen_code_ai.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatersRepository theatersRepository;

    public List<ShowtimeResponse> getAllShowtime() {
        return showtimeRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    public ShowtimeResponse createShowtime(ShowtimeRequest request) {
        ShowtimeEntity showtime = convertToEntity(request);
        ShowtimeEntity savedShowtime = showtimeRepository.save(showtime);
        return convertToResponse(savedShowtime);
    }

    public ShowtimeResponse updateShowtime(ShowtimeRequest request) {
        ShowtimeEntity showtime = showtimeRepository.findById(request.getShowtimeId()).orElseThrow(() -> new ShowtimeNotFoundException("Showtime not found with id: " + request.getShowtimeId()));
        updateShowtimeFromRequest(showtime, request);
        ShowtimeEntity updatedShowtime = showtimeRepository.save(showtime);
        return convertToResponse(updatedShowtime);
    }

    public ShowtimeResponse getShowtimeById(Integer id) {
        ShowtimeEntity showtime = showtimeRepository.findById(id).orElseThrow(() -> new ShowtimeNotFoundException("Showtime not found with id: " + id));
        return convertToResponse(showtime);
    }

    public void deleteShowtime(Integer id) {
        if (!showtimeRepository.existsById(id)) {
            throw new ShowtimeNotFoundException("Showtime not found with id: " + id);
        }
        showtimeRepository.deleteById(id);
    }


    private ShowtimeEntity convertToEntity(ShowtimeRequest request) {
        ShowtimeEntity showtime = new ShowtimeEntity();
        updateShowtimeFromRequest(showtime, request);
        return showtime;
    }

    private void updateShowtimeFromRequest(ShowtimeEntity showtime, ShowtimeRequest request) {
        MovieEntity movie = movieRepository.findById(request.getMovieId()).orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + request.getMovieId()));
        TheatersEntity theater = theatersRepository.findById(request.getTheaterId()).orElseThrow(() -> new TheaterNotFoundException("Theater not found with id: " + request.getTheaterId()));

        showtime.setMovie(movie);
        showtime.setTheater(theater);
        showtime.setStartTime(DateTimeUtil.convertToLocalDateTime(request.getStartTime()));
        showtime.setEndTime(DateTimeUtil.convertToLocalDateTime(request.getEndTime()));
        showtime.setPrice(request.getPrice());
    }


    // convert showtime entity to showtime response
    private ShowtimeResponse convertToResponse(ShowtimeEntity showtime) {
        ShowtimeResponse response = new ShowtimeResponse();
        response.setShowtimeId(showtime.getShowtimeId());
        response.setMovieId(showtime.getMovie().getId());
        response.setTheaterId(showtime.getTheater().getId());
        response.setStartTime(DateTimeUtil.convertToOffsetDateTime(showtime.getStartTime()));
        response.setEndTime(DateTimeUtil.convertToOffsetDateTime(showtime.getEndTime()));
        response.setPrice(showtime.getPrice());
        return response;
    }
}