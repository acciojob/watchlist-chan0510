package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();
    HashMap<String,String> movieDirectorPair = new HashMap<>();
    public String addMovie(Movie movie){
        String key=movie.getName();
        movieDb.put(key,movie);
        return "Movie added Successfully";
    }
    public String addDirector(Director director){
        String key=director.getName();
        directorDb.put(key, director);
        return " Director added Sucessfully";
    }
    public String addMovieDirectorPair(String movieName, String directorName){
        movieDirectorPair.put(movieName,directorName);
        return "Successfully added";
    }
    public  Movie getMovieByName(String name){
        return movieDb.get(name);
    }
    public Director getDirectorByName(String name){
        return directorDb.get(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> ans= new ArrayList<>();
       for(String movie : movieDirectorPair.keySet()){
           if(movieDirectorPair.get(movie).equals(director))ans.add(movie);
       }
       return  ans;
    }
    public List<String> findAllMovies(){
        List<String >ans=new ArrayList<>();
        movieDb.forEach((k,v)->{
            ans.add(k);
        });
        return ans;
    }
    public String deleteDirectorByName(String directorName){
        directorDb.remove(directorName);
        for(Map.Entry<String,String> entry : movieDirectorPair.entrySet()){
            String movieName=entry.getKey();
            movieDb.remove(movieName);
            movieDirectorPair.remove(movieName);
        }

        return  "Successfully Deleted Director";
    }
    public String deleteAllDirectors(){
        for (String directorName: directorDb.keySet()){
            directorDb.remove(directorName);
            for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()){
                if(entry.getValue().equals(directorName)){
                    String movieName=entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }
        return " Successfully deleted";
    }

}
