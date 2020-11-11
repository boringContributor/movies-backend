package com.assignment.cic.service;

import com.assignment.cic.model.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

  @Autowired private RestTemplate restTemplate;

  @Value("${api.uri}")
  private String uri;

  public List<MovieData> getAllMovieData() {
    MovieData[] movieData = restTemplate.getForObject(uri, MovieData[].class);
    return Arrays.asList(movieData);
  }

  public List<String> getTitleByLocation(String location) {
    MovieData[] movieData = restTemplate.getForObject(uri, MovieData[].class);
    return Arrays.stream(movieData)
            .filter(movie -> movie.getLocations() != null && movie.getLocations().equals(location))
                .map(MovieData::getTitle).collect(Collectors.toList());
  }

  public List<String> getLocationByTitle(String title) {
      MovieData[] movieData = restTemplate.getForObject(uri, MovieData[].class);
      return Arrays.stream(movieData)
              .filter(movie -> movie.getTitle() != null && movie.getTitle().equals(title))
              .map(MovieData::getLocations).collect(Collectors.toList());
  }
}
