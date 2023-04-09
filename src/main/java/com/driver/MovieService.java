package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
        String ans=movieRepository.addMovie(movie);
        return ans;
    }
    public String addDirector(Director director){
        String ans= movieRepository.addDirector(director);
        return  ans;
    }
    public  String addMovieDirectorPair(String movieName, String directorName){
        String ans= movieRepository.addMovieDirectorPair(movieName,directorName);
        return  ans;
    }
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return  movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> ans= movieRepository.getMoviesByDirectorName(director);
        return ans;
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}
