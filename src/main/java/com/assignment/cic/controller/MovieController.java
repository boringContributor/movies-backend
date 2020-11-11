package com.assignment.cic.controller;

import com.assignment.cic.model.MovieData;
import com.assignment.cic.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

  @Autowired private MovieService movieService;

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<List<MovieData>> getAllMovieData() {
    List<MovieData> movieDataList = movieService.getAllMovieData();
    return new ResponseEntity<>(
        movieDataList, movieDataList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
  }

  @RequestMapping(
      method = RequestMethod.GET,
      produces = "application/json",
      value = "/titles/{title}")
  public ResponseEntity<List<String>> getLocationByTitle(@PathVariable("title") String title) {
    try {
      List<String> movieDataList = movieService.getLocationByTitle(title);
      return new ResponseEntity<>(
              movieDataList, movieDataList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(
      method = RequestMethod.GET,
      produces = "application/json",
      value = "/locations/{location}")
  public ResponseEntity<List<String>> getTitleByLocation(
      @PathVariable("location") String location) {
    try {
      List<String> movieDataList = movieService.getTitleByLocation(location);
      return new ResponseEntity<>(
              movieDataList, movieDataList.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
