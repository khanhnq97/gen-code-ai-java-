package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.dto.ShowtimeRequest;
import com.example.gen_code_ai.dto.ShowtimeResponse;
import com.example.gen_code_ai.exception.ShowtimeNotFoundException;
import com.example.gen_code_ai.service.ShowtimeService;
import com.example.gen_code_ai.web.ShowtimesApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowtimeController implements ShowtimesApi {

  @Autowired private ShowtimeService showtimeService;

  @Override
  public ResponseEntity<List<ShowtimeResponse>> getShowtimes() {
    List<ShowtimeResponse> showtimes = showtimeService.getAllShowtime();
    return ResponseEntity.ok(showtimes);
  }

  @Override
  public ResponseEntity<ShowtimeResponse> createShowtime(ShowtimeRequest showtimeRequest) {
    ShowtimeResponse createdShowtime = showtimeService.createShowtime(showtimeRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdShowtime);
  }

  @Override
  public ResponseEntity<ShowtimeResponse> updateShowtime(ShowtimeRequest showtimeRequest) {
    try {
      ShowtimeResponse updatedShowtime = showtimeService.updateShowtime(showtimeRequest);
      return ResponseEntity.ok(updatedShowtime);
    } catch (ShowtimeNotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @Override
  public ResponseEntity<ShowtimeResponse> getShowtimeById(Long id) {
    try {
      ShowtimeResponse showtime = showtimeService.getShowtimeById(id);
      return ResponseEntity.ok(showtime);
    } catch (ShowtimeNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<Void> deleteShowtime(Long id) {
    try {
      showtimeService.deleteShowtime(id);
      return ResponseEntity.noContent().build();
    } catch (ShowtimeNotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
